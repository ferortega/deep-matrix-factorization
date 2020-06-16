# Grid Search

## MovieLens 100K

### DeepMF

```
Best parameters set found on development set:

DeepMF(numFactors=[3, 3, 3, 3]; numIters=[50, 50, 50, 50]; learningRate=[0.01, 0.1, 0.01, 0.1]; regularization=[0.1, 0.01, 0.1, 0.01])

MAE scores on development set:

0.7501660489832702 for DeepMF(numFactors=[3, 3, 3, 3]; numIters=[50, 50, 50, 50]; learningRate=[0.01, 0.1, 0.01, 0.1]; regularization=[0.1, 0.01, 0.1, 0.01])
0.7507687871663927 for DeepMF(numFactors=[3, 3, 3, 9]; numIters=[50, 50, 50, 50]; learningRate=[0.01, 0.1, 0.01, 0.1]; regularization=[0.1, 0.01, 0.1, 0.01])
0.7507855626016539 for DeepMF(numFactors=[3, 6, 6, 3]; numIters=[50, 50, 50, 50]; learningRate=[0.01, 0.1, 0.01, 0.1]; regularization=[0.1, 0.01, 0.1, 0.01])
0.7509245609929954 for DeepMF(numFactors=[3, 3, 3]; numIters=[50, 50, 50]; learningRate=[0.01, 0.1, 0.01]; regularization=[0.1, 0.01, 0.1])
0.7510519973255916 for DeepMF(numFactors=[3, 3, 9, 9]; numIters=[50, 50, 50, 50]; learningRate=[0.01, 0.1, 0.01, 0.1]; regularization=[0.1, 0.01, 0.1, 0.01])
0.7510968705698701 for DeepMF(numFactors=[6, 3, 3, 6]; numIters=[50, 50, 50, 50]; learningRate=[0.01, 0.1, 0.01, 0.1]; regularization=[0.1, 0.01, 0.1, 0.01])
0.7512153879015555 for DeepMF(numFactors=[3, 9, 9]; numIters=[50, 50, 50]; learningRate=[0.01, 0.1, 0.01]; regularization=[0.1, 0.01, 0.1])
0.7513784767577023 for DeepMF(numFactors=[6, 6, 6, 3]; numIters=[50, 50, 50, 50]; learningRate=[0.01, 0.1, 0.01, 0.1]; regularization=[0.1, 0.01, 0.1, 0.01])
0.7514113013464785 for DeepMF(numFactors=[3, 9, 9, 3]; numIters=[50, 50, 50, 50]; learningRate=[0.01, 0.1, 0.01, 0.1]; regularization=[0.1, 0.01, 0.1, 0.1])
0.7514313821971464 for DeepMF(numFactors=[3, 6, 3, 6]; numIters=[50, 50, 50, 50]; learningRate=[0.01, 0.1, 0.01, 0.1]; regularization=[0.1, 0.01, 0.1, 0.01])
0.7515921104324546 for DeepMF(numFactors=[3, 6, 3, 6]; numIters=[50, 50, 50, 50]; learningRate=[0.01, 0.1, 0.1, 0.1]; regularization=[0.1, 0.01, 0.1, 0.01])
0.7516797116996549 for DeepMF(numFactors=[3, 9, 9, 3]; numIters=[50, 50, 50, 50]; learningRate=[0.01, 0.1, 0.01, 0.1]; regularization=[0.1, 0.01, 0.1, 0.01])
0.7517266886518051 for DeepMF(numFactors=[6, 9, 9, 3]; numIters=[50, 50, 50, 50]; learningRate=[0.01, 0.1, 0.01, 0.1]; regularization=[0.1, 0.01, 0.1, 0.01])
0.751764810711465 for DeepMF(numFactors=[6, 3, 3, 9]; numIters=[50, 50, 50, 50]; learningRate=[0.01, 0.1, 0.01, 0.1]; regularization=[0.1, 0.01, 0.1, 0.01])
0.751813823431472 for DeepMF(numFactors=[3, 6, 3, 3]; numIters=[50, 50, 50, 50]; learningRate=[0.01, 0.1, 0.1, 0.1]; regularization=[0.1, 0.01, 0.1, 0.01])
```

### PMF

```
Best parameters set found on development set:

{numIters=50, lambda=0.025, seed=43, gamma=0.01, numFactors=2}

MAE scores on development set:

0.767200 for {numIters=50, lambda=0.025, seed=43, gamma=0.01, numFactors=2}
0.767236 for {numIters=50, lambda=0.030000000000000002, seed=43, gamma=0.01, numFactors=2}
0.767236 for {numIters=50, lambda=0.02, seed=43, gamma=0.01, numFactors=2}
0.767332 for {numIters=50, lambda=0.034999999999999996, seed=43, gamma=0.01, numFactors=2}
0.767351 for {numIters=50, lambda=0.015, seed=43, gamma=0.01, numFactors=2}
0.767477 for {numIters=50, lambda=0.04, seed=43, gamma=0.01, numFactors=2}
0.767589 for {numIters=50, lambda=0.01, seed=43, gamma=0.01, numFactors=2}
0.767676 for {numIters=50, lambda=0.045, seed=43, gamma=0.01, numFactors=2}
0.767924 for {numIters=50, lambda=0.049999999999999996, seed=43, gamma=0.01, numFactors=2}
0.768027 for {numIters=50, lambda=0.005, seed=43, gamma=0.01, numFactors=2}
```

### NMF

```
Best parameters set found on development set:

{seed=43, numIters=50, numFactors=2}

MAE scores on development set:

0.791382 for {seed=43, numIters=50, numFactors=2}
0.811110 for {seed=43, numIters=50, numFactors=4}
0.823357 for {seed=43, numIters=50, numFactors=6}
0.830506 for {seed=43, numIters=50, numFactors=8}
0.836400 for {seed=43, numIters=50, numFactors=10}
```

### SVD++

```
Best parameters set found on development set:

{numIters=50, lambda=0.08, seed=43, gamma=0.0014000000000000002, numFactors=2}

MAE scores on development set:

0.781704 for {numIters=50, lambda=0.08, seed=43, gamma=0.0014000000000000002, numFactors=2}
0.781722 for {numIters=50, lambda=0.06999999999999999, seed=43, gamma=0.0014000000000000002, numFactors=2}
0.781773 for {numIters=50, lambda=0.09, seed=43, gamma=0.0014000000000000002, numFactors=2}
0.781848 for {numIters=50, lambda=0.060000000000000005, seed=43, gamma=0.0014000000000000002, numFactors=2}
0.781897 for {numIters=50, lambda=0.09999999999999999, seed=43, gamma=0.0014000000000000002, numFactors=2}
0.782134 for {numIters=50, lambda=0.05, seed=43, gamma=0.0014000000000000002, numFactors=2}
0.782609 for {numIters=50, lambda=0.04, seed=43, gamma=0.0014000000000000002, numFactors=2}
0.782909 for {numIters=50, lambda=0.08, seed=43, gamma=0.0013, numFactors=2}
0.782947 for {numIters=50, lambda=0.09, seed=43, gamma=0.0013, numFactors=2}
0.782955 for {numIters=50, lambda=0.06999999999999999, seed=43, gamma=0.0013, numFactors=2}
```


## MovieLens 1M

### DeepMF

```
Best parameters set found on development set:

DeepMF(numFactors=[9, 3, 3]; numIters=[50, 50, 50]; learningRate=[0.01, 0.01, 0.01]; regularization=[0.1, 0.01, 0.1])

MAE scores on development set:

0.709433030518752 for DeepMF(numFactors=[9, 3, 3]; numIters=[50, 50, 50]; learningRate=[0.01, 0.01, 0.01]; regularization=[0.1, 0.01, 0.1])
0.7094844173094 for DeepMF(numFactors=[9, 3, 9, 3]; numIters=[50, 50, 50, 50]; learningRate=[0.01, 0.01, 0.01, 0.1]; regularization=[0.1, 0.01, 0.1, 0.01])
0.7094944071629923 for DeepMF(numFactors=[9, 3, 9]; numIters=[50, 50, 50]; learningRate=[0.01, 0.01, 0.01]; regularization=[0.1, 0.01, 0.1])
0.7095621176052527 for DeepMF(numFactors=[9, 3, 3, 9]; numIters=[50, 50, 50, 50]; learningRate=[0.01, 0.01, 0.01, 0.1]; regularization=[0.1, 0.01, 0.1, 0.01])
0.7095938083964222 for DeepMF(numFactors=[9, 3, 3, 3]; numIters=[50, 50, 50, 50]; learningRate=[0.01, 0.01, 0.01, 0.1]; regularization=[0.1, 0.01, 0.1, 0.01])
0.709745412550849 for DeepMF(numFactors=[9, 3, 3, 6]; numIters=[50, 50, 50, 50]; learningRate=[0.01, 0.01, 0.01, 0.1]; regularization=[0.1, 0.01, 0.1, 0.01])
0.7097637713034022 for DeepMF(numFactors=[9, 3, 6, 3]; numIters=[50, 50, 50, 50]; learningRate=[0.01, 0.01, 0.01, 0.1]; regularization=[0.1, 0.01, 0.1, 0.01])
0.7098128650085577 for DeepMF(numFactors=[9, 3, 6]; numIters=[50, 50, 50]; learningRate=[0.01, 0.01, 0.01]; regularization=[0.1, 0.01, 0.1])
0.7098229016459924 for DeepMF(numFactors=[9, 3]; numIters=[50, 50]; learningRate=[0.01, 0.01]; regularization=[0.1, 0.01])
0.7098697229264492 for DeepMF(numFactors=[9, 3, 9, 6]; numIters=[50, 50, 50, 50]; learningRate=[0.01, 0.01, 0.01, 0.1]; regularization=[0.1, 0.01, 0.1, 0.01])
0.7099890064722555 for DeepMF(numFactors=[9, 3, 6, 9]; numIters=[50, 50, 50, 50]; learningRate=[0.01, 0.01, 0.01, 0.1]; regularization=[0.1, 0.01, 0.1, 0.01])
0.7099992449366441 for DeepMF(numFactors=[9, 3, 9, 9]; numIters=[50, 50, 50, 50]; learningRate=[0.01, 0.01, 0.01, 0.1]; regularization=[0.1, 0.01, 0.1, 0.01])
0.7100301943810485 for DeepMF(numFactors=[9, 3, 3, 3]; numIters=[50, 50, 50, 50]; learningRate=[0.01, 0.1, 0.1, 0.01]; regularization=[0.1, 0.1, 0.1, 0.01])
0.7102190229895555 for DeepMF(numFactors=[9, 3, 6, 6]; numIters=[50, 50, 50, 50]; learningRate=[0.01, 0.01, 0.01, 0.1]; regularization=[0.1, 0.01, 0.1, 0.01])
0.7102545419169862 for DeepMF(numFactors=[9, 3, 3, 3]; numIters=[50, 50, 50, 50]; learningRate=[0.01, 0.1, 0.01, 0.1]; regularization=[0.1, 0.1, 0.01, 0.01])
```

### PMF

```
Best parameters set found on development set:

{numIters=50, lambda=0.045, seed=43, gamma=0.01, numFactors=8}

MAE scores on development set:

0.718681 for {numIters=50, lambda=0.045, seed=43, gamma=0.01, numFactors=8}
0.718801 for {numIters=50, lambda=0.04, seed=43, gamma=0.01, numFactors=8}
0.718810 for {numIters=50, lambda=0.049999999999999996, seed=43, gamma=0.01, numFactors=8}
0.719177 for {numIters=50, lambda=0.055, seed=43, gamma=0.01, numFactors=8}
0.719208 for {numIters=50, lambda=0.034999999999999996, seed=43, gamma=0.01, numFactors=8}
0.719788 for {numIters=50, lambda=0.06, seed=43, gamma=0.01, numFactors=8}
0.719954 for {numIters=50, lambda=0.030000000000000002, seed=43, gamma=0.01, numFactors=8}
0.720601 for {numIters=50, lambda=0.04, seed=43, gamma=0.01, numFactors=6}
0.720628 for {numIters=50, lambda=0.034999999999999996, seed=43, gamma=0.01, numFactors=6}
0.720635 for {numIters=50, lambda=0.065, seed=43, gamma=0.01, numFactors=8}
```

### NMF

```
Best parameters set found on development set:

{seed=43, numIters=50, numFactors=2}

MAE scores on development set:

0.751660 for {seed=43, numIters=50, numFactors=2}
0.769076 for {seed=43, numIters=50, numFactors=4}
0.772235 for {seed=43, numIters=50, numFactors=6}
0.779943 for {seed=43, numIters=50, numFactors=8}
0.780913 for {seed=43, numIters=50, numFactors=10}
```

### SVD++

```
Best parameters set found on development set:

{numIters=50, lambda=0.05, seed=43, gamma=0.0014000000000000002, numFactors=4}

MAE scores on development set:

0.742856 for {numIters=50, lambda=0.05, seed=43, gamma=0.0014000000000000002, numFactors=4}
0.743028 for {numIters=50, lambda=0.060000000000000005, seed=43, gamma=0.0014000000000000002, numFactors=4}
0.743189 for {numIters=50, lambda=0.04, seed=43, gamma=0.0014000000000000002, numFactors=4}
0.743536 for {numIters=50, lambda=0.06999999999999999, seed=43, gamma=0.0014000000000000002, numFactors=4}
0.744209 for {numIters=50, lambda=0.08, seed=43, gamma=0.0014000000000000002, numFactors=4}
0.744419 for {numIters=50, lambda=0.03, seed=43, gamma=0.0014000000000000002, numFactors=4}
0.744607 for {numIters=50, lambda=0.060000000000000005, seed=43, gamma=0.0014000000000000002, numFactors=6}
0.744706 for {numIters=50, lambda=0.06999999999999999, seed=43, gamma=0.0014000000000000002, numFactors=6}
0.744732 for {numIters=50, lambda=0.05, seed=43, gamma=0.0013, numFactors=4}
0.744798 for {numIters=50, lambda=0.060000000000000005, seed=43, gamma=0.0013, numFactors=4}
```


## FilmTrust

### DeepMF

```
Best parameters set found on development set:

DeepMF(numFactors=[6, 6, 3]; numIters=[50, 50, 50]; learningRate=[0.01, 0.1, 0.01]; regularization=[0.1, 0.01, 0.01])

MAE scores on development set:

0.6493615046366756 for DeepMF(numFactors=[6, 6, 3]; numIters=[50, 50, 50]; learningRate=[0.01, 0.1, 0.01]; regularization=[0.1, 0.01, 0.01])
0.6498702123501671 for DeepMF(numFactors=[6, 6, 3]; numIters=[50, 50, 50]; learningRate=[0.01, 0.1, 0.01]; regularization=[0.1, 0.01, 0.1])
0.6507198876641032 for DeepMF(numFactors=[6, 3, 6]; numIters=[50, 50, 50]; learningRate=[0.01, 0.1, 0.01]; regularization=[0.1, 0.01, 0.1])
0.6508757201396091 for DeepMF(numFactors=[9, 3, 3]; numIters=[50, 50, 50]; learningRate=[0.01, 0.1, 0.01]; regularization=[0.1, 0.01, 0.1])
0.6510179998606596 for DeepMF(numFactors=[6, 6]; numIters=[50, 50]; learningRate=[0.01, 0.01]; regularization=[0.1, 0.01])
0.6519366807024988 for DeepMF(numFactors=[6, 3, 3]; numIters=[50, 50, 50]; learningRate=[0.01, 0.1, 0.01]; regularization=[0.1, 0.01, 0.01])
0.6530137268885391 for DeepMF(numFactors=[6, 6]; numIters=[50, 50]; learningRate=[0.01, 0.1]; regularization=[0.1, 0.01])
0.6542858956360406 for DeepMF(numFactors=[9, 6, 3, 3]; numIters=[50, 50, 50, 50]; learningRate=[0.01, 0.1, 0.01, 0.1]; regularization=[0.1, 0.1, 0.1, 0.01])
0.6547165625573627 for DeepMF(numFactors=[6, 6, 3]; numIters=[50, 50, 50]; learningRate=[0.01, 0.01, 0.01]; regularization=[0.1, 0.01, 0.1])
0.6548406756096803 for DeepMF(numFactors=[6, 3, 6]; numIters=[50, 50, 50]; learningRate=[0.01, 0.01, 0.01]; regularization=[0.1, 0.01, 0.1])
0.6549248398674361 for DeepMF(numFactors=[9, 3]; numIters=[50, 50]; learningRate=[0.01, 0.1]; regularization=[0.1, 0.01])
0.6550493174294717 for DeepMF(numFactors=[6, 3, 3]; numIters=[50, 50, 50]; learningRate=[0.01, 0.01, 0.01]; regularization=[0.1, 0.01, 0.1])
0.6551746987037559 for DeepMF(numFactors=[9, 3, 3, 9]; numIters=[50, 50, 50, 50]; learningRate=[0.01, 0.1, 0.01, 0.1]; regularization=[0.1, 0.01, 0.01, 0.1])
0.655272387162197 for DeepMF(numFactors=[9, 6, 6, 3]; numIters=[50, 50, 50, 50]; learningRate=[0.01, 0.1, 0.1, 0.01]; regularization=[0.1, 0.1, 0.1, 0.01])
0.6553289550964211 for DeepMF(numFactors=[6, 6, 3, 9]; numIters=[50, 50, 50, 50]; learningRate=[0.01, 0.1, 0.01, 0.1]; regularization=[0.1, 0.01, 0.1, 0.1])
```

### PMF

```
Best parameters set found on development set:

{numIters=50, lambda=0.1, seed=43, gamma=0.015, numFactors=4}

MAE scores on development set:

0.846590 for {numIters=50, lambda=0.1, seed=43, gamma=0.015, numFactors=4}
0.846833 for {numIters=50, lambda=0.095, seed=43, gamma=0.015, numFactors=4}
0.847251 for {numIters=50, lambda=0.09000000000000001, seed=43, gamma=0.015, numFactors=4}
0.847326 for {numIters=50, lambda=0.005, seed=43, gamma=0.015, numFactors=2}
0.847882 for {numIters=50, lambda=0.01, seed=43, gamma=0.015, numFactors=2}
0.847973 for {numIters=50, lambda=0.085, seed=43, gamma=0.015, numFactors=4}
0.848154 for {numIters=50, lambda=0.015, seed=43, gamma=0.02, numFactors=2}
0.848223 for {numIters=50, lambda=0.02, seed=43, gamma=0.02, numFactors=2}
0.848327 for {numIters=50, lambda=0.01, seed=43, gamma=0.02, numFactors=2}
0.848343 for {numIters=50, lambda=0.015, seed=43, gamma=0.015, numFactors=2}
```

### NMF

```
Best parameters set found on development set:

{seed=43, numIters=50, numFactors=2}

MAE scores on development set:

0.829119 for {seed=43, numIters=50, numFactors=2}
0.848695 for {seed=43, numIters=50, numFactors=4}
0.855264 for {seed=43, numIters=50, numFactors=6}
0.867049 for {seed=43, numIters=50, numFactors=10}
0.879115 for {seed=43, numIters=50, numFactors=8}
```

### SVD++

```
Best parameters set found on development set:

{numIters=50, lambda=0.09999999999999999, seed=43, gamma=0.0014000000000000002, numFactors=2}

MAE scores on development set:

0.657489 for {numIters=50, lambda=0.09999999999999999, seed=43, gamma=0.0014000000000000002, numFactors=2}
0.658202 for {numIters=50, lambda=0.09, seed=43, gamma=0.0014000000000000002, numFactors=2}
0.659117 for {numIters=50, lambda=0.08, seed=43, gamma=0.0014000000000000002, numFactors=2}
0.659926 for {numIters=50, lambda=0.09999999999999999, seed=43, gamma=0.0013, numFactors=2}
0.660287 for {numIters=50, lambda=0.06999999999999999, seed=43, gamma=0.0014000000000000002, numFactors=2}
0.660770 for {numIters=50, lambda=0.09, seed=43, gamma=0.0013, numFactors=2}
0.661809 for {numIters=50, lambda=0.08, seed=43, gamma=0.0013, numFactors=2}
0.661934 for {numIters=50, lambda=0.060000000000000005, seed=43, gamma=0.0014000000000000002, numFactors=2}
0.662801 for {numIters=50, lambda=0.09999999999999999, seed=43, gamma=0.0012000000000000001, numFactors=2}
0.663125 for {numIters=50, lambda=0.06999999999999999, seed=43, gamma=0.0013, numFactors=2}
```


## MyAnimeList

### DeepMF

```
Best parameters set found on development set:

DeepMF(numFactors=[9, 6, 9, 6]; numIters=[50, 50, 50, 50]; learningRate=[0.01, 0.1, 0.01, 0.1]; regularization=[0.1, 0.01, 0.1, 0.01])

MAE scores on development set:

0.9744677425601693 for DeepMF(numFactors=[9, 6, 9, 6]; numIters=[50, 50, 50, 50]; learningRate=[0.01, 0.1, 0.01, 0.1]; regularization=[0.1, 0.01, 0.1, 0.01])
0.9745197400710806 for DeepMF(numFactors=[9, 9, 6, 9]; numIters=[50, 50, 50, 50]; learningRate=[0.01, 0.1, 0.01, 0.1]; regularization=[0.1, 0.01, 0.1, 0.01])
0.9745382706864003 for DeepMF(numFactors=[9, 6, 6, 6]; numIters=[50, 50, 50, 50]; learningRate=[0.01, 0.1, 0.01, 0.1]; regularization=[0.1, 0.01, 0.1, 0.01])
0.9745389499841043 for DeepMF(numFactors=[9, 6, 6, 9]; numIters=[50, 50, 50, 50]; learningRate=[0.01, 0.1, 0.01, 0.1]; regularization=[0.1, 0.01, 0.1, 0.01])
0.9745832620776561 for DeepMF(numFactors=[9, 9, 9, 6]; numIters=[50, 50, 50, 50]; learningRate=[0.01, 0.1, 0.01, 0.1]; regularization=[0.1, 0.01, 0.1, 0.01])
0.9745853211900029 for DeepMF(numFactors=[9, 9, 3, 9]; numIters=[50, 50, 50, 50]; learningRate=[0.01, 0.1, 0.01, 0.1]; regularization=[0.1, 0.01, 0.1, 0.01])
0.9746431486428571 for DeepMF(numFactors=[9, 9, 6, 6]; numIters=[50, 50, 50, 50]; learningRate=[0.01, 0.1, 0.01, 0.1]; regularization=[0.1, 0.01, 0.1, 0.01])
0.9748385826095393 for DeepMF(numFactors=[9, 6, 9, 9]; numIters=[50, 50, 50, 50]; learningRate=[0.01, 0.1, 0.01, 0.1]; regularization=[0.1, 0.01, 0.1, 0.01])
0.9748485614031205 for DeepMF(numFactors=[9, 9, 9, 9]; numIters=[50, 50, 50, 50]; learningRate=[0.01, 0.1, 0.01, 0.1]; regularization=[0.1, 0.01, 0.1, 0.01])
0.9750770084805775 for DeepMF(numFactors=[9, 6, 3, 9]; numIters=[50, 50, 50, 50]; learningRate=[0.01, 0.1, 0.01, 0.1]; regularization=[0.1, 0.01, 0.1, 0.01])
0.9751777988557613 for DeepMF(numFactors=[9, 6, 3, 6]; numIters=[50, 50, 50, 50]; learningRate=[0.01, 0.1, 0.01, 0.1]; regularization=[0.1, 0.01, 0.1, 0.01])
0.9753627732355025 for DeepMF(numFactors=[9, 9, 3, 6]; numIters=[50, 50, 50, 50]; learningRate=[0.01, 0.1, 0.01, 0.1]; regularization=[0.1, 0.01, 0.1, 0.01])
0.9753780169939325 for DeepMF(numFactors=[9, 6, 9, 3]; numIters=[50, 50, 50, 50]; learningRate=[0.01, 0.1, 0.01, 0.1]; regularization=[0.1, 0.01, 0.1, 0.01])
0.9754014742710679 for DeepMF(numFactors=[9, 6, 6, 3]; numIters=[50, 50, 50, 50]; learningRate=[0.01, 0.1, 0.01, 0.1]; regularization=[0.1, 0.01, 0.1, 0.01])
0.9754386682557895 for DeepMF(numFactors=[9, 9, 9, 3]; numIters=[50, 50, 50, 50]; learningRate=[0.01, 0.1, 0.01, 0.1]; regularization=[0.1, 0.01, 0.1, 0.01])
```

### PMF

```
Best parameters set found on development set:

{numIters=50, lambda=0.085, seed=43, gamma=0.005, numFactors=10}

MAE scores on development set:

1.100057 for {numIters=50, lambda=0.085, seed=43, gamma=0.005, numFactors=10}
1.100132 for {numIters=50, lambda=0.09000000000000001, seed=43, gamma=0.005, numFactors=10}
1.100141 for {numIters=50, lambda=0.08, seed=43, gamma=0.005, numFactors=10}
1.100348 for {numIters=50, lambda=0.095, seed=43, gamma=0.005, numFactors=10}
1.100388 for {numIters=50, lambda=0.07500000000000001, seed=43, gamma=0.005, numFactors=10}
1.100703 for {numIters=50, lambda=0.1, seed=43, gamma=0.005, numFactors=10}
1.100796 for {numIters=50, lambda=0.07, seed=43, gamma=0.005, numFactors=10}
1.101299 for {numIters=50, lambda=0.034999999999999996, seed=43, gamma=0.005, numFactors=4}
1.101319 for {numIters=50, lambda=0.04, seed=43, gamma=0.005, numFactors=4}
1.101346 for {numIters=50, lambda=0.030000000000000002, seed=43, gamma=0.005, numFactors=4}
```

### NMF

```
Best parameters set found on development set:

{seed=43, numIters=50, numFactors=2}

MAE scores on development set:

1.120250 for {seed=43, numIters=50, numFactors=2}
1.150784 for {seed=43, numIters=50, numFactors=4}
1.175432 for {seed=43, numIters=50, numFactors=6}
1.186780 for {seed=43, numIters=50, numFactors=8}
1.190961 for {seed=43, numIters=50, numFactors=10}
```

### SVD++

```
Best parameters set found on development set:

{numIters=50, lambda=0.02, seed=43, gamma=0.0014000000000000002, numFactors=4}

MAE scores on development set:

0.951791 for {numIters=50, lambda=0.02, seed=43, gamma=0.0014000000000000002, numFactors=4}
0.952106 for {numIters=50, lambda=0.03, seed=43, gamma=0.0014000000000000002, numFactors=6}
0.952280 for {numIters=50, lambda=0.03, seed=43, gamma=0.0014000000000000002, numFactors=4}
0.952644 for {numIters=50, lambda=0.04, seed=43, gamma=0.0014000000000000002, numFactors=6}
0.952884 for {numIters=50, lambda=0.02, seed=43, gamma=0.0014000000000000002, numFactors=2}
0.952950 for {numIters=50, lambda=0.04, seed=43, gamma=0.0014000000000000002, numFactors=4}
0.953211 for {numIters=50, lambda=0.05, seed=43, gamma=0.0014000000000000002, numFactors=6}
0.953589 for {numIters=50, lambda=0.01, seed=43, gamma=0.0014000000000000002, numFactors=2}
0.953597 for {numIters=50, lambda=0.03, seed=43, gamma=0.0014000000000000002, numFactors=2}
0.953782 for {numIters=50, lambda=0.05, seed=43, gamma=0.0014000000000000002, numFactors=4}
```