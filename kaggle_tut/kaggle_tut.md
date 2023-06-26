# 机器学习和 Kaggle 初步

## 一、机器学习基础和 Kaggle 简介

### 1. 机器学习

#### 1.1 机器学习的定义
* 根据现有数据找规律    
* 基于大数据的科学 Statistics based on Big Data

#### 1.2 为什么需要机器学习
* 实际场景数据高维、非结构化、隐氏  
* 实际任务多样、复杂   
* 图像分割、语音识别、文本实体抽取

#### 1.3 机器学习通用流程  

* 训练数据 ($X_i,Y_i$) -> 学习 -> 模型 -> 测试数据 ($X_j$) -> 测试结果 ($Y_j$)

#### 1.4 机器学习三大类别
* **监督学习**    
  给定数据：特征+**标签** ($X_i,Y_i$) -> 给定$X_j$预测$Y_j$     
  用途：分类问题 / 回归问题   
* **非监督学习**    
  给定$X_i$ -> 分析特征 $f(X_i)$，$f(X_j)$  
  用途：概率统计 / 降维 / 聚类  
* **强化学习**   

**监督学习常用模型和算法：**

* 线性回归
* 决策树
* 逻辑回归
* 朴素贝叶斯
* 支持向量机
* 神经网络 (MLP)

**Kaggle常用模型和算法：**

* **数据挖掘**：XGB, LGB, CAT...
* **CV**：EfficientNet, U-Net, Transformer...
* **NLP**：BERT, DeBERTa, RoBERTa...

## 2. 模型评价和标准

**回归问题 Regression**：MAE, MSE, RMSE, $r^2$

**分类问题**：混淆矩阵、准确度 / 精度 / 召回 、 F1-Score

* **混淆矩阵:**

|      		|Guessed Positive|Guessed Negative|
| --------| ---------------|----------------|
|Positive |True Positive	 |False Negative	|
|Negative |False Positive  |True  Negative  |

* **准确度：** $Accuracy = \frac{FN+FP}{total}$

* **精度：** $Precision = \frac{TP}{TP+FP}$

* **召回率：** $Recall = \frac{TP}{TP+FN}$

* **调和平均：** $F1 Score = 2 * \frac{Pre * Recall}{Pre + Recall}$

* $F-\beta Score$： $F_\beta = \frac{(1+\beta^2)precision*recall}{\beta^2*precision+recall}$

**多分类问题**同样可以推广得到，分为 micro 和 macro。

### 3. 验证集和过拟合

**机器模型数据集类别：**

* 训练集 (Training Set)
* 验证集 (Validation Set)
* 测试集 (Testing Set)

**欠拟合和过拟合**

* 过拟合的特点：训练集表现良好，验证集表现一般

### 4. Kaggle简介

Kaggle 上有丰富的比赛(Featured 和 Research)和数据集，常见的有

* **CV：**图像分类 / 目y		应用 **Keras**, **PyTorch**

* **NLP：**实体识别、分类 / 回归

  ​		**<分类>**标准 F1-Score, F-beta, QWK, Accuracy

  ​		**<回归>**标准 MAE,MSE; mAP, loU,Dice; SvoMAE

* **数据挖掘：**应用 **LightGBM**, **XGBoost**, **CatBoost**, **Pytorch (nn)**

  

## 二、优化论基础和决策树算法

### 1. 优化论

#### 1.1 线性回归

* **一元线性回归**

  学习目标：$f(x) = ax + b$

  计算方法：最小化 **MSE** $Q(a, b)$，即真实值和估计值之差

* **多元线性回归：**特征多元向量

  学习目标：$f(X) = W^T X +b$

  计算方法：最小化 $||y-X\bar{w}||_2^2$ ，即差值的二范数，本质是优化问题

#### 1.2 优化方法 (无约束优化)

* **高阶(导数)法：** 梯度和 Hessian 矩阵

* **无约束迭代法：**

  选择初始点，设置容差限 -> 决定**搜索方向** -> 决定步长，构建迭代，直至小于容差限

* **(随机)梯度下降法：** 

  应用 $f(x_k+d_k) \approx f(x_k) +g^T(x_k)d_k$，要求一阶**泰勒展开**比较准确

  举例：求解 $f(x, y) = x^2 +100y^2 +4$ 的最小值

  ```python
  eps = 1e-5
  x = 4
  y = 5
  alpha = 0.001
  
  while (abs(-2*x) + abs(-200*y) > eps)
  		x += alpha*(-2*x)
    	y += alpha*(-200*y)
      print(x**2 + 100*y**2 + 4)
  ```

### 2. 决策树 

* **常见决策树** Decision (if-else) Tree：**ID3**, **C4.5**, **CART**

* **训练关键：**选择条件**优先级**
  * ID3, C4.5：信息熵，信息增益
  * 信息增益大的**优先**分裂
* **分类回归树 (CART)：**
  * D3无法处理连续特征且依赖数据集本身
  * 分类回归树是**二叉树**

