package com.yiniu.weka;

import weka.clusterers.ClusterEvaluation;
import weka.clusterers.SimpleKMeans;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class SimpleKMeansTest {

	public static void main(String[] args) throws Exception {
		DataSource test_data = new DataSource("E://test.arff");// 读测试数据

		Instances insTest = test_data.getDataSet();
		SimpleKMeans KM = new SimpleKMeans();
		KM.setNumClusters(3);
		Instance inst = new DenseInstance(insTest.numAttributes());
		inst.setValue(insTest.attribute(0), 22);
		inst.setValue(insTest.attribute(1), 23);

		KM.buildClusterer(insTest);
		ClusterEvaluation eval = new ClusterEvaluation();
		eval.setClusterer(KM);
		eval.evaluateClusterer(insTest);
		System.out.println(eval.clusterResultsToString());
		System.out.println(KM.clusterInstance(inst));
	}
}
