# Grid Search

## MovieLens 1M

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