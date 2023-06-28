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

* **调和平均：** $F_1 Score = 2 * \frac{Pre * Recall}{Pre + Recall}$

* $F_\beta Score$： $F_\beta = \frac{(1+\beta^2)precision*recall}{\beta^2*precision+recall}$

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

* **CV：**图像分类、目标检测 / 图像分割		应用 **Keras**, **PyTorch**

* **NLP：**实体识别、分类 / 回归

  **<分类>**标准 F1-Score, F-beta, QWK, Accuracy

  **<回归>**标准 MAE,MSE; mAP, loU,Dice; SvoMAE

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

* **训练关键：** 选择条件**优先级**
  * ID3, C4.5：**信息熵**，**信息增益**，即 $Ent(D) = \sum_{k=1}^{K}p_k\log_2p_k$
  * 信息增益大的**优先**分裂
  
* **分类回归树 (CART)：**
  * D3无法处理连续特征且依赖数据集本身
  
  * 分类回归树是**二叉树**，需判断**阈值**
  
  * 用**基尼 (Gini) 指数**近似信息熵，即 $gini(T_i) = 1 - p^2 - (1-p)^2$
  
    ```matlab
    x = 0.0001: 0.0001: 0.9999;
    y1 = -x.*1og2 (x) - (1-x).*1og2 (1-x) ;
    y2 = 2.* (1-x.^2 - (1-x).^2) ;
    plot (x, y1);
    hold on 
    plot (x, y2);
    xlabel (' p') 
    legend (Ent', 'Gini') 
    hold off
    ```

* **集成：梯度提升决策树 (GBDT)**

  * **Bagging**：随机森林

    数据重新收集，多模型平均 / 投票

    优点：robust，模型较稳定；

    缺陷：存在预测界限，模型提升有限。

  * **Boosting**：GBDT, XGBoost, LightGBM, CatBoost

    提取前一轮误差，进行下一轮拟合，循环往复

    * **XGBoost**：叠加 CART，综合泰勒二阶展开

      调参模块：详见 https://xgboost.readthedocs.io/en/latest/parameter.html

      ```python
      params = {'objective': 'reg:linear'		# 拟合目标
      'eta': 0.01,													# 学习率：0.001～0.1
      'max_depth': 11,											# 单颗树分裂次数：5～12
      'subsample': 0.5,
      'colsample_bytree': 0.5,
      'silent': 1
      'seed': 1
      }
      num_trees = 10000
      ```

      模版：

      ```python
      from sklearn.model_selection import train_test_split
      X_train, X_test = train_test_split(train, test_size=0.2, random_state=2)
      dtrain = xgb.DMatrix(X_train[ features], np.log1p(X_train.Sales))
      dvalid = xgb. DMatrix(X_test [features], np. log1p(X_test.Sales))
      dtest = xgb. DMatrix(test [features])
      watchlist = [(dtrain, 'train'), (dvalid, 'eval')]
      gbm = xgb. train(params, dtrain, num_trees, evals=watchlist, early_stopping_rounds=50, feval=rmsp
      e_xg, verbose_eval=False)
      ```

    * **LightGBM：**微软基于 XGBoost 的集成工具包

      XGBoost 优化速度较慢，遇到工业级数据处理困难

      **用 histogram 方法优化：**储存空间更小 (离散化)，计算复杂度低

      **用GOSS优化：**选取部分大梯度数据

      **用EBF优化：**互斥特征捆绑

      字典形式：详见 https://lightgbm.readthedocs.io/en/latest/Parameters.html

      ```python
      params = {
      'task': 'train',
      'boosting_type': 'gbat',
      'objective': 'regression'
      'metric'
      'rmse',
      'num_leaves': 40,					# 分裂数：32～256
      'subsample': 0.8,
      'learning_rate': 0.03,		# 学习率
      'verbose': 1,
      'lambda_12': 3
      }
      num_trees = 1000
      ```

      ```python
      d_train = Igb. Dataset (train_features, train_target, categorical_feature=categorical_features)
      d_eval = 1gb. Dataset (test_features, test_target, categorical_feature=categorical_features)
      print("Building model meter :", val, 'fold:',
      md = Igb. train (params, d_train, num_boost_round=num_trees, valid_sets=(d_train, d_eval),
      early-stopping_rounds=243,verbose_eval=20)
      ```

      函数模式：

      ```python
      skf = StratifiedkFold/n
      splits=5, shuffle=True, random state=2019)
      Ic1f = IGBMClassifier(
      		learning_rate=0.05, 
        	n_estimators=10000, 
        	subsample=0.8, 
        	subsample freq=l, 
        	colsample_bytree=0.8, 
        	random state=2019
      amt_oof = np.zeros(train num)
      prob_oof = np.zeros((train num, 33))
      test_pred_prob = np.zeros((test_values.shape [0], 33))
      for i, (trn_idx, val_idx) in enumerate (skf.split (train_values, clf_labels)):
      	print (i, 'fold...')
      	t = time.time()
      	
        trn_x, trn_y = train_values [trn_idx], clf_labels[trn_idx]
      	val _x, val_y = train values[val idx], clf labels[val idx]
      	val_repay_amt = amt_ Iabels [val idx)
      	val_due_amt = train_due_amt_df.iloc[val_idx]
      	clf.fitt(
      			trn_x, trn_y,
      			eval_set=[(trn_x, trn_y), (val x, val_y)], 
          	early_stopping_rounds=100, verbose=5
        )
      ```

    * **CatBoost：**对GPU有很好的支持，接口统一、代码规范，方便集成

      模版：详见 https://catboost.ai/docs

      ```python
      cbr = CatBoostRegressor (n_estimators=100,
      												 use_best_model=True, 
                               objective='RMSE',
                               loss_function='RMSE',
                               boosting_type='Plain',
                               eval_metric='RMSE',
      												 12_leaf_reg=1,
                               learning_rate=0.03, 
                               max depth=8, 
                               task_type='CPU'
                              )
      categorical_featuress['building_id','site_id', 'primary_use', 'had_air_temperature', 'had_cloud_coverage','had_dew_temperature','had_precip_depth_1_hr', 'had_sea_level_pressure', 'had_wind_direction','had_wind_speed','tm_day_of_week','tm_hour_of_day']
      
      train_features = X1.iloc[train_index]
      train_target = y[X1.iloc[train_index].index]
      test_features = X1.iloc[test_index]
      test_target = y[X1.iloc [test_index].index]
      print("Building model meter:", val, 'fold:',t)
      md = cbr.fit(train_features, train_target, eval_set=(test_features, test_target),
      						 cat_features=categorical_features, early_stopping_rounds=500, verbose=10)	
      ```

### 3.特征工程初步

#### 3.1 数据挖掘的通用流程

* 数据预处理和特征抽取
* 模型训练
* 结果后处理

#### 3.2 探索性数据分析 (EDA)

* **缺失值处理：**去除、插补和忽略

* **数值转换：**

  * MIin-max转化、标准化转换、分位式转换
  * 对数转换，对偏度大于0.75的标签数据应用 `np.log10()`

* **特征组合 / 交叉：**

  将双特征作积 (笛卡尔积 / hadamard积) 得到更显著的模型特征 

* **其他技巧：**

  * 独热编码 (子都分类特征)

  * 时间戳处理：

    ```python
    data['Year'] = data.Date.dt.year
    data['Month'] = data. Date.dt.month
    data ['Day'] = data.Date.dt.day
    data['DayOfWeek'] = data. Date.dt.dayofweek
    data['WeekOfYear'] = data.Date.dt.weekofyear
    ```

  * 降维处理 (PCA, LGB & CAT, t-SNE, UMAP)
