package com.yiniu.weka;
import java.util.ArrayList;

import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.functions.LinearRegression;
import weka.classifiers.functions.Logistic;
import weka.clusterers.ClusterEvaluation;
import weka.clusterers.Clusterer;
import weka.clusterers.EM;
import weka.clusterers.SimpleKMeans;
import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;  
import weka.core.converters.ConverterUtils.DataSource;
import weka.experiment.AveragingResultProducer;
import weka.filters.Filter;
import weka.filters.supervised.instance.Resample;
import weka.filters.unsupervised.attribute.MathExpression;
import weka.filters.unsupervised.attribute.Remove;
import weka.filters.unsupervised.attribute.Standardize;

  
public class WekaDemo {  
	//weka过滤器
	
	 public static Instances BoostrapSample(Instances data) {
		 String[] options = new String[4];
		 options[0] = "-R";                                    // "range"
		 options[1] = "1";
		 options[2] = "-E";                                    // "range"
		 options[3] = "ifelse(A>10,2,3)";
		 MathExpression me = new MathExpression();
	        try {
	        	me.setOptions(options);
	        	me.setInputFormat(data);
	            data = Filter.useFilter(data, me);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return data;
	    }
	 
	 /**
	  * 
	  * @Description TODO
	  * @date 2016年8月19日
	  * @author Con Zhang
	  * @param @param data
	  * @param @throws Exception
	  * @return Instances
	  */
	 public static Instances StandardizeTest(Instances data) throws Exception {
		 Standardize st = new Standardize();
		 st.setInputFormat(data);
		 return Filter.useFilter(data, st);
	    }
	 
    public static void main(String[] args) throws Exception {  
        // TODO Auto-generated method stub  
        DataSource train_data = new DataSource("E://train.arff");//读训练数据  
        DataSource test_data = new DataSource("E://test1.arff");//读测试数据  
          
        Instances insTrain = train_data.getDataSet();  
        Instances insTest = test_data.getDataSet();  
        
       
        insTrain.setClassIndex(insTrain.numAttributes()-1);//设置训练集中，target的index  
        insTest.setClassIndex(insTest.numAttributes()-1);//设置测试集中，target的index  
       
        NaiveBayes nb = new NaiveBayes();
        nb.buildClassifier(insTest);
        System.out.println(nb.toString());
        ClusterEvaluation eval = new ClusterEvaluation(); //构造评价器
        
      /*  Instances test = new WekaDemo().BoostrapSample(insTest);
        System.out.println("==========================="+test.toString());*/
        
        
        
       /* ClusterEvaluation eval = new ClusterEvaluation();
        Clusterer clusterer = new EM();                                 // new clusterer instance, default options
        clusterer.buildClusterer(insTrain);                                 // build clusterer
        eval.setClusterer(clusterer);                                   // the cluster to evaluate
        eval.evaluateClusterer(insTest);                                // data to evaluate the clusterer on
        System.out.println("# of clusters: " + eval.getNumClusters());
        System.out.println(eval.clusterResultsToString());
        */
        
         // 4.打印聚类结果
         
       // Instances tempIns = KM.getClusterCentroids();
       // System.out.println(KM.toString());
      /*  for(String option : KM.getOptions()) {  
          System.out.println(option);  
      }  */
      //  System.out.println("********************CentroIds: " + tempIns);

        
        //增加一个ID编号
        
       /* AddID filter = new AddID(); 

        String[] options = new String[4]; 

        options[0] = "-C"; 

        options[1] = "first"; 

        options[2] = "-N"; 

        options[3] = "ID"; 

        filter.setOptions(options); 

        filter.setInputFormat(insTrain); 

        Instances newInstances = Filter.useFilter(insTrain, filter); 

        System.out.println("----------------"+newInstances.toSummaryString()); 
        System.out.println(newInstances.toString());
       
        
        
 
      ArrayList<Attribute> att = new ArrayList<Attribute>();
      
      for(int count = 0; count<3; count++){
    	    att.add(new Attribute(String.valueOf(count + "age")));
    	 }

       Instances in = new Instances("data", att,0);
        
        Instance inst = new DenseInstance(3);
        inst.setValue(in.attribute(0), 23);
        inst.setValue(in.attribute(1), 33);
        inst.setValue(in.attribute(2), 43);
        in.add(inst);
        System.out.println(in.toString());*/
       
       
        
        /*LinearRegression lr = new LinearRegression();//定义分类器的类型  
        lr.buildClassifier(insTrain);//训练分类器  
          
        Evaluation eval=new Evaluation(insTrain);  
        eval.evaluateModel(lr, insTest);//评估效果  
        System.out.println(eval.meanAbsoluteError());//计算ＭＡＥ  
        String model=lr.toString();
        System.out.println(model);
        double[] cf = lr.coefficients();
        System.out.println(cf[0]);*/
    }  
  
}  