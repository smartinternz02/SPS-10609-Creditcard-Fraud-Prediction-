//To split Data set into train and test sets
import weka.core.Instances;

import java.io.File;
import java.util.Random;
import weka.core.converters.ArffSaver;
import weka.core.converters.ConverterUtils.DataSource;
public class TestTrainSplit{
	public static void main(String args[]) throws Exception{
		//load dataset
		DataSource source = new DataSource("C:\\Users\\Dell\\Downloads\\fraud_dataset1.arff");
		Instances dataset = source.getDataSet();	
		//set class index to the last attribute
		dataset.setClassIndex(dataset.numAttributes()-1);

		int seed = 1;
		int folds = 15;
		
		//randomize data
		Random rand = new Random(seed);
		
		//create random dataset
		Instances randData = new Instances(dataset);
		randData.randomize(rand);
		
		//stratify	    
		if (randData.classAttribute().isNominal())
			randData.stratify(folds);

		// perform cross-validation	    	    
		for (int n = 0; n < folds; n++) {
		
			//get the folds	
			Instances train = randData.trainCV(folds, n);
			Instances test = randData.testCV(folds, n);	      

			ArffSaver saver = new ArffSaver();
			saver.setInstances(train);
		//	System.out.println("No of folds done = " + (n+1));

			saver.setFile(new File("traincredit.arff"));
			saver.writeBatch();
			if(n==9)
			{
				System.out.println("Training set generated after the final fold is");
			System.out.println(train);
			System.out.println("Testing set generated after the final fold is");
			System.out.println(test);
			}

			ArffSaver saver1 = new ArffSaver();
			saver1.setInstances(test);
			saver1.setFile(new File("testcredit.arff"));
			saver1.writeBatch();
		}
	}
}