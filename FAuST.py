#!/usr/bin/env python
# coding: utf-8

# In[ ]:


from random import sample
import numpy as np
from numpy import linalg as la
import copy
import pandas as pd

############################################################
#                   AUXILIARY FUNCTIONS                    #
############################################################

def get_worst(v, s, threshold = 10**(-3)):
    ''' Given the vector v, returns the len(v) - s
    indices of the smallest elements.
    
    Input
    v: Array of tuples (value, i, j), where
    i and j are the indices of the entry of the matrix M
    where the value is placed.
    threshold: margin for soft comparison.
    '''
    worst = []
    
    v.sort() # Sorts increasingly
    i = 0
    n_select = len(v) - s # Number of elements to be modified
    while i < len(v) and n_select > 0:
        value = v[i][0]
        indices_value = []
        
        # Finds all the elements of v with the same value
        # than the current one.
        while i < len(v) and abs(v[i][0] - value) < threshold:
            indices_value.append([v[i][1], v[i][2]])
            i += 1
            
        if n_select - len(indices_value) >= 0: # The found elements fit
            worst = worst + indices_value
        else: # The found elements do not fit -> subsampling
            worst = worst + sample(indices_value, int(n_select))
        n_select -= len(indices_value)
        
    return worst       

def projection(M, s):
    '''
        Project M to an sparsity matrix with at most s
        non-vanishing entries, and with Frobenious norm 1.
        
        The function takes M and, except the s entries with highest
        absolute value, set the other entries to zero. Finally,
        normalizes the obtained matrix.
        
        Input
        M: Matrix to be projected.
        s: Number of elements to preserve.
    '''
    v = []
    M_original = copy.copy(M)
    for i in range(M.shape[0]):
        for j in range(M.shape[1]):
            v.append([abs(M[i,j]), i, j])

    worst = get_worst(v, s)
    cont = 0
    for i, j in worst:
        cont += 1
        M[i,j] = 0

    if la.norm(M, 'fro') < 0.0001:
        return non_square_id(M.shape[0], M.shape[1])
    
    return M/la.norm(M, 'fro')

def non_square_id(n, m):
    '''
        Returns a 'rentangular identity matrix' of order n x m.
        That is, a matrix M with M[i,i] = 1 and M[i,j] = 0 for i != j.
        
        n: rows
        m: columns
    '''
    M = np.matrix(np.zeros((n, m)))
    for i in range(min(n,m)):
        M[i,i] = 1
    return M

def left_product_matrices(S, order_id = 1):
    '''
        Accepts an array of matrices S and multiplies them
        on the left. That is, it returs
        
        S[n]*...*S[2]*S[1]*S[0]
        
        If S is the empty list, it returns the identity matrix
        of order order_id.
    '''
    if len(S) == 0:
        return np.matrix(np.identity(order_id))
    
    res = S[0]
    for i in range(1, len(S)):
        res = S[i]*res
        
    return res
    
def filter_non_voted(A, M, n_filtered = False):
    '''
        Filters those entries of M that were not voted in the
        matrix of ratings A.
        
        The used convention is that the entry (i, j) of A has
        not been voted if A[i,j] < 0.
        
        This function allows that the cost function of palm4MSA
        only takes into account the voted entries.
        
        A: matrix of ratings.
        M: matriz to be filtered.
    '''
    
    Mp = copy.copy(M)
    cont = 0
    for i in range(A.shape[0]):
        for j in range(A.shape[1]):
            if A[i,j] < 0:     # The (i,j) entry of the recommendation matrix was not voted.
                Mp[i,j] = 0
            else:
                cont += 1

    if n_filtered:
        return Mp, cont
    else:
        return Mp

def create_default_Ss(dims):
    '''
        Returns the default initialization for a factorization S with the specified dimensions.
        The matrices are obtained with random entries drawn from a (0,1)-uniform distribution.
        
        Dims: vector of length 3 with the dimensions n_rows, factors y n_cols
        of the factorization, respectively.
    '''
    n_rows, factors, n_cols = dims
    Ss = [np.matrix(np.random.rand(factors, n_cols)), np.matrix(np.random.rand(n_rows, factors))]
    return Ss




############################################################
#                        MAIN FUNCTIONS                    #
############################################################
    
def palm4MSA(A, J, constrs, Ss_init, lamb_init, N, mu = 0.001):
    '''
        Main algorithm of factorization.
        
        Factorizes the matrix A into J different factors, taking
        as initialization the values of Ss_init and lamb_init.
        
        The result of the factorization is
        
        A = lambda * S[J]*...*S[2]*S[1]*S[0]
        
        Remark: As the matrices S[j] are normalized, it uses the
        numerical factor lambda to ajust the norm.
        
        Input
        A: Matrix to be factorized.
        J: Number of factors to obtain.
        constrs: Array of length J that contains the maximum number
        of allowed non-vanishing elements in the output factorization.
        In this way, constrs[j] contains the maximum number of non-zero
        elements allowed in S[j].
        Ss_init: Initial values for S[0], ..., S[J].
        lamb_init: Value for initial lambda.
        N: Number of iterations of the gradient descent optimization method.
        mu: Initial step size (learning rate) of the gradient descent.
        
        Returns: S (array with the factorization) and
        lambda (constant of the factorization)
    '''
    S = copy.copy(Ss_init)
    lamb = copy.copy(lamb_init)
    for i in range(N):
        mu_step = mu + i/(N-1)*(0.1*mu - mu) # Linear decreasing of the learning rate from mu to 10% of mu
        for j in range(J):
            L = left_product_matrices(S[j+1:], A.shape[0]) # Parte izquierda a S[j]
            R = left_product_matrices(S[:j], A.shape[1])   # Parte derecha a S[j]
            
            error, n_filtered = filter_non_voted(A, lamb*L*S[j]*R-A,  n_filtered = True)
            if i%10 == 0:
                print('Iteration '+ str(i + 1) + '/' + str(N) + ' - Factor ' + str(j+1) + ' MAE: ' + str(la.norm(error.A1, 1)/n_filtered))
            B = S[j] - mu_step*lamb*L.T*(error)*R.T
            # filter_non_voted sets to zero the non-voted indices
            # Rmk: If there was no CF, the code will be:
            # B = S[j] - mu_step*lamb*L.transpose()*(lamb*L*S[j]*R-A)*R.transpose()
            
            
            # No normalization: S[j] = B
            S[j] = projection(B, constrs[j])
            # Rmk: If there are no requirements of sparsity, the code will be
            # S[j] = B/la.norm(B, 'fro')
        
        hat_A = left_product_matrices(S) # Resulting matrix
        
        numer = np.trace(A.T*hat_A)
        denom = max(np.trace(hat_A.T*hat_A), 10**(-10)) # Avoids division by zero
        lamb = numer/denom
        # No normalization: lamb = 1
        
    return S, lamb

def FAuST(A, factors, constrs, constrs_tilde, N_local, N_global, mus_local, mus_global):
    '''
        Main method.
        
        Performs the hierarchical factorization of A into the product of J spare matrices,
        where J is the length of constrs (equivalently, the length of the factors + 1).
        
        The result of the factorization is
        
        A = lambda * S[J]*...*S[2]*S[1]*S[0]
        
        Remark: Since the matrices S[j] are normalized, the function uses
        a numerical factor lambda to ajust the norm.
        
        A: Matrix to be factorized.
        
        HIPER-PARAMETERS
        factors: number of hidden factors of each of the J factorizations.
        It is a vector of length J-1.
        constrs: Non-vanishing elements allowed in the factorization.
        Vector of length J.
        constrs_tilde: Non-vanishing elements of the factorization of the residues.
        Vector of length J-1.
        N_local: Number of iterations of the local factorizations.
        N_global: Number of iterations of the global factorizations.
        mus_local: Vector of learning rates for the local factorizations.
        mus_global: Vector of learning rates for the global factorizations.
    '''
    T = A
    J = len(factors) + 1
    dims = [A.shape[0]] + factors + [A.shape[1]]
    
    default_lamb = 1
    global_lamb = default_lamb
    Ss = []
    # Respecto a la notacion del paper: s = l-1
    for s in range(J-1):
        print('********')
        print('Deep: '+str(s))
        
        ## LOCAL FACTORIZATION
        dimensions_default = [T.shape[0], factors[s], T.shape[1]]
        default_Ss = create_default_Ss(dimensions_default)
        F, lamb = palm4MSA(T, 2, [constrs_tilde[s], constrs[s]], default_Ss, default_lamb,                           N_local, mus_local[s])
        F1, F2 = F
        
        mse, mae = test_result(F, lamb, T)
        print('MAE after local factorization: ' + str(mae))
        
        ## GLOBAL FACTORIZATION
        Ss.append(F1)
        T = F2
        Ss_init_global = Ss + [T]
        global_Ss, global_lamb = palm4MSA(A, s+2, constrs[:s+1] + [constrs_tilde[s]],                                          Ss_init_global, lamb*global_lamb, N_global, mus_global[s])
        T = global_Ss[-1]
        Ss = global_Ss[:-1]
        mse, mae = test_result(global_Ss, global_lamb, A)
        print('MAE after global factorization: ' + str(mae))
    
    Ss.append(T)
    
    return Ss, global_lamb


# In[ ]:


df_train = pd.read_csv('ml100k_train.csv', header=None)
df_test = pd.read_csv('ml100k_test.csv', header=None)

R = df_train.to_numpy()
R_test = df_test.to_numpy()


# In[ ]:


def test_result(S, lamb, R_test):
    Rp = lamb*left_product_matrices(S)
    T, n_votes = filter_non_voted(R_test, Rp-R_test, n_filtered = True)
    return la.norm(T.A1, 2)**2/n_votes, la.norm(T.A1, 1)/n_votes #MSE, MAE

def test_FAuST(R, R_test, factors, constrs, constrs_tilde, N, alphas, out_file):
    S, lamb = FAuST(R, factors, constrs, constrs_tilde, N, N, alphas, alphas)
    f = open(out_file, "a")
    mse, mae = test_result(S, lamb, R_test)
    res = str(factors) + ',' + str(constrs) + ',' + str(constrs_tilde) + ',' + str(N) + ',' + str(alphas)         + ',' + str(mae) + ',' + str(mse) + '\n'
    f.write(res)    
    f.close()

def generate_list(size, character):
    if size==0:
        return [[]]
    l = generate_list(size-1, character)
    res = []
    for lis in l:
        for n in range(character):
            res.append(lis+[n])
    
    return res 
    
# Limits
# 2 leq J leq 4
# factors: 6, 9
# constrs/constr_tilde: 1, 0.8
# N = 200
# alphas = 0.0001, 0.01
def grid_search(R, R_test, out_file):
    factors_values = [6, 9]
    constrs_values = [1, 0.8]
    constrs_tilde_reduction = [1]
    mus_values = [0.0001, 0.01]
    N = 50
    
    for J in range(2, 4 + 1):
        total = len(generate_list(J-1, len(factors_values)))*len(generate_list(J, len(constrs_values)))*len(generate_list(J-1, len(constrs_tilde_reduction)))*2
        cont = 0
        for factors_indices in generate_list(J-1, len(factors_values)):
            factors = [factors_values[k] for k in factors_indices]
            factors_rev = copy.copy(factors)
            factors_rev.reverse()
            dims = [R.shape[1]] + factors_rev + [R.shape[0]]
                    
            for constrs_indices in generate_list(J, len(constrs_values)):
                constrs = [int(constrs_values[constrs_indices[k]]*dims[k]*dims[k+1]) for k in range(J)]
                
                for constrs_tilde_indices in generate_list(J-1, len(constrs_tilde_reduction)):
                    constrs_tilde = [int(constrs[k]*constrs_tilde_reduction[constrs_tilde_indices[k]]) for k in range(J-1)]
                    
                    for mu in mus_values:
                        mus = [mu]*(J-1)
                        cont += 1
                        
                        print('Test ' + str(cont) + '/' + str(total) + ' for J='+str(J))
                        print(factors)
                        print(constrs)
                        print(constrs_tilde)
                        print(mus)
                        test_FAuST(R, R_test, factors, constrs, constrs_tilde, N, mus, out_file)


# In[ ]:


out_file = 'FAuST_results.txt'

grid_search(R, R_test, out_file)


# In[ ]:




