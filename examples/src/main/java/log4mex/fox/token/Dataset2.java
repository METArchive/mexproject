package log4mex.fox.token;

import org.aksw.mex.log4mex.MEXSerializer;
import org.aksw.mex.log4mex.MyMEX;
import org.aksw.mex.log4mex.algo.AlgorithmVO;
import org.aksw.mex.util.MEXConstant;
import org.aksw.mex.util.MEXEnum.*;

import java.util.Date;

/**
 * Created by Moussallem on 26.04.16.
 */
public class Dataset2 {

    public static void main(String[] args) {

        System.out.println("starting Fox");

        //the MEX wrapper!
        MyMEX mex = new MyMEX();

        try{

        //basic authoring provenance
        {
            //change later here the sets for adds
            mex.setAuthorName("René Speck");
            mex.setAuthorEmail("speck@informatik.uni-leipzig.de");
            mex.setContext(EnumContexts.NAMED_ENTITY_RECOGNITION);
            mex.setOrganization("Leipzig University");

            mex.setExperimentId("E1_token");
            mex.setExperimentTitle("token-based experiment");
            mex.setExperimentDate(new Date());
            mex.setExperimentDescription("Token-based evaluation on 15 ensemble learning algorithms");
        }

        String eid = "E001S002";
        //ml-experiment-configuration
        {
            mex.addConfiguration(eid);

            mex.Configuration(eid).setDescription("analyzing 10-fold cross validation for 15 algorithms");
            //mex.Configuration(eid).setModel("svm20150322", "model generated by LibSVM", new Date());
            mex.Configuration(eid).setSamplingMethod(EnumSamplingMethods.CROSS_VALIDATION, 10);
            mex.Configuration(eid).SamplingMethod().setTrainSize(0.9);
            mex.Configuration(eid).SamplingMethod().setTestSize(0.1);
            mex.Configuration(eid).SamplingMethod().setSequential(true);

            mex.Configuration(eid).setHardwareConfiguration("ubuntu", EnumProcessors.INTEL_COREI7, EnumRAM.SIZE_16GB, "SSD", EnumCaches.CACHE_3MB);


            mex.Configuration(eid).DataSet().setName("News*");
            mex.Configuration(eid).DataSet().setDescription("a small subset of the dataset News which consists of text from newspaper articles and was re-annotated manually by the authors to ensure high data quality.");
            mex.Configuration(eid).DataSet().setURI("https://github.com/AKSW/FOX/tree/master/input/2");

        }

        //adding algorithms and parameters
        String alg1,alg2,alg3,alg4,alg5,alg6,alg7,alg8,alg9,alg10,alg11,alg12,alg13,alg14,alg15,alg16,alg17,alg18,alg19;
        {
            //mex.Configuration(eid).setImplementation(EnumImplementations., "3.6.6");

            alg1 = mex.Configuration(eid).addAlgorithm(EnumAlgorithms.BaggingJ48);
            alg2 = mex.Configuration(eid).addAlgorithm(EnumAlgorithms.SequentialMinimalOptimization);
            alg3 = mex.Configuration(eid).addAlgorithm(EnumAlgorithms.AdditiveLogisticRegression);
            alg4 = mex.Configuration(eid).addAlgorithm(EnumAlgorithms.DecisionTable);
            alg5 = mex.Configuration(eid).addAlgorithm(EnumAlgorithms.NaiveBayes);
            alg6 = mex.Configuration(eid).addAlgorithm(EnumAlgorithms.SimpleVoting);
            alg7 = mex.Configuration(eid).addAlgorithm(EnumAlgorithms.LogisticModelTrees);
            alg8 = mex.Configuration(eid).addAlgorithm(EnumAlgorithms.NER_OPEN_NLP);
            alg9 = mex.Configuration(eid).addAlgorithm(EnumAlgorithms.MultilayerPerceptron);
            alg10 = mex.Configuration(eid).addAlgorithm(EnumAlgorithms.J48);
            alg11 = mex.Configuration(eid).addAlgorithm(EnumAlgorithms.NER_STANFORD);
            alg12 = mex.Configuration(eid).addAlgorithm(EnumAlgorithms.SupportVectorMachines);
            alg13 = mex.Configuration(eid).addAlgorithm(EnumAlgorithms.NER_ILLINOIS_EXTENDED);
            alg14 = mex.Configuration(eid).addAlgorithm(EnumAlgorithms.FunctionalTrees);
            alg15 = mex.Configuration(eid).addAlgorithm(EnumAlgorithms.AdaBoostM1);
            alg16 = mex.Configuration(eid).addAlgorithm(EnumAlgorithms.ClassLevelVoting);
            alg17 = mex.Configuration(eid).addAlgorithm(EnumAlgorithms.NER_BALIE);
            alg18 = mex.Configuration(eid).addAlgorithm(EnumAlgorithms.RandomForest);
            alg19 = mex.Configuration(eid).addAlgorithm(EnumAlgorithms.LogisticRegression);

            String[] param = {"C", "10^3", "alpha", "0.2"};

            mex.Configuration(eid).Algorithm(alg1).addParameter(param);


        }

        String ex1;
        String ex2;
        String ex3;
        String ex4;
        String ex5;
        String ex6;
        String ex7;
        String ex8;
        String ex9;
        String ex10;
        String ex11;
        String ex12;
        String ex13;
        String ex14;
        String ex15;
        String ex16;
        String ex17;
        String ex18;
        String ex19;
        
        //associate your run x each algorithm
        {
            ex1 = mex.Configuration(eid).addExecution(EnumExecutionsType.OVERALL, EnumPhases.TEST);

            mex.Configuration(eid).Execution(ex1).setStartDate(new Date());
            mex.Configuration(eid).Execution(ex1).setAlgorithm(mex.Configuration(eid).addAlgorithm(EnumAlgorithms.SequentialMinimalOptimization));
            //mex.Configuration(eid).Execution(ex1).setStartsAtPosition("1233");
           // mex.Configuration(eid).Execution(ex1).setEndsAtPosition("1376");
            mex.Configuration(eid).Execution(ex1).addPerformance(EnumMeasures.RECALL, .6347);
            mex.Configuration(eid).Execution(ex1).addPerformance(EnumMeasures.PRECISION, .7245);
            mex.Configuration(eid).Execution(ex1).addPerformance(EnumMeasures.FMEASURE, .6749);
            mex.Configuration(eid).Execution(ex1).addPerformance(EnumMeasures.ERROR, 3.57);
            mex.Configuration(eid).Execution(ex1).addPerformance(EnumMeasures.MATTHEWSCORRELATIONCOEFICIENT, 0.659);

                //your models call here !
            mex.Configuration(eid).Execution(ex1).setEndDate(new Date());
        }
        
        
         {
            ex2 = mex.Configuration(eid).addExecution(EnumExecutionsType.OVERALL, EnumPhases.TEST);
           // mex.Configuration(eid).setExecutionId(0, ex1);

            mex.Configuration(eid).Execution(ex2).setStartDate(new Date());
            mex.Configuration(eid).Execution(ex2).setAlgorithm(mex.Configuration(eid).addAlgorithm(EnumAlgorithms.AdditiveLogisticRegression));
            //mex.Configuration(eid).Execution(ex1).setStartsAtPosition("1233");
           // mex.Configuration(eid).Execution(ex1).setEndsAtPosition("1376");
            mex.Configuration(eid).Execution(ex2).addPerformance(EnumMeasures.RECALL, .6047);
            mex.Configuration(eid).Execution(ex2).addPerformance(EnumMeasures.PRECISION, .7748);
            mex.Configuration(eid).Execution(ex2).addPerformance(EnumMeasures.FMEASURE, .6757);
            mex.Configuration(eid).Execution(ex2).addPerformance(EnumMeasures.ERROR, 3.4);
            mex.Configuration(eid).Execution(ex2).addPerformance(EnumMeasures.MATTHEWSCORRELATIONCOEFICIENT, .665);

                //your models call here !
            mex.Configuration(eid).Execution(ex2).setEndDate(new Date());
        }
         
                 {
            ex3 = mex.Configuration(eid).addExecution(EnumExecutionsType.OVERALL, EnumPhases.TEST);
           // mex.Configuration(eid).setExecutionId(0, ex1);

            mex.Configuration(eid).Execution(ex3).setStartDate(new Date());
            mex.Configuration(eid).Execution(ex3).setAlgorithm(mex.Configuration(eid).addAlgorithm(EnumAlgorithms.DecisionTable));
            //mex.Configuration(eid).Execution(ex1).setStartsAtPosition("1233");
           // mex.Configuration(eid).Execution(ex1).setEndsAtPosition("1376");
            mex.Configuration(eid).Execution(ex3).addPerformance(EnumMeasures.RECALL, .6280);
            mex.Configuration(eid).Execution(ex3).addPerformance(EnumMeasures.PRECISION, .7418);
            mex.Configuration(eid).Execution(ex3).addPerformance(EnumMeasures.FMEASURE, .6785);
            mex.Configuration(eid).Execution(ex3).addPerformance(EnumMeasures.ERROR, 3.43);
            mex.Configuration(eid).Execution(ex3).addPerformance(EnumMeasures.MATTHEWSCORRELATIONCOEFICIENT, .664);

                //your models call here !
            mex.Configuration(eid).Execution(ex3).setEndDate(new Date());
        }
                 
                {
            ex4 = mex.Configuration(eid).addExecution(EnumExecutionsType.OVERALL, EnumPhases.TEST);
           // mex.Configuration(eid).setExecutionId(0, ex1);

            mex.Configuration(eid).Execution(ex4).setStartDate(new Date());
            mex.Configuration(eid).Execution(ex4).setAlgorithm(mex.Configuration(eid).addAlgorithm(EnumAlgorithms.NaiveBayes));
            //mex.Configuration(eid).Execution(ex1).setStartsAtPosition("1233");
           // mex.Configuration(eid).Execution(ex1).setEndsAtPosition("1376");
            mex.Configuration(eid).Execution(ex4).addPerformance(EnumMeasures.RECALL, .7119);
            mex.Configuration(eid).Execution(ex4).addPerformance(EnumMeasures.PRECISION, .6342);
            mex.Configuration(eid).Execution(ex4).addPerformance(EnumMeasures.FMEASURE, .6688);
            mex.Configuration(eid).Execution(ex4).addPerformance(EnumMeasures.ERROR, 4.42);
            mex.Configuration(eid).Execution(ex4).addPerformance(EnumMeasures.MATTHEWSCORRELATIONCOEFICIENT, .647);

                //your models call here !
            mex.Configuration(eid).Execution(ex4).setEndDate(new Date());
        }
                
                        {
           ex5 =  mex.Configuration(eid).addExecution(EnumExecutionsType.OVERALL, EnumPhases.TEST);
           // mex.Configuration(eid).setExecutionId(0, ex1);

            mex.Configuration(eid).Execution(ex5).setStartDate(new Date());
            mex.Configuration(eid).Execution(ex5).setAlgorithm(mex.Configuration(eid).addAlgorithm(EnumAlgorithms.SimpleVoting));
            //mex.Configuration(eid).Execution(ex1).setStartsAtPosition("1233");
           // mex.Configuration(eid).Execution(ex1).setEndsAtPosition("1376");
            mex.Configuration(eid).Execution(ex5).addPerformance(EnumMeasures.RECALL, .6699);
            mex.Configuration(eid).Execution(ex5).addPerformance(EnumMeasures.PRECISION, .5475);
            mex.Configuration(eid).Execution(ex5).addPerformance(EnumMeasures.FMEASURE, .5859);
            mex.Configuration(eid).Execution(ex5).addPerformance(EnumMeasures.ERROR, 6.02);
            mex.Configuration(eid).Execution(ex5).addPerformance(EnumMeasures.MATTHEWSCORRELATIONCOEFICIENT, .567);

                //your models call here !
            mex.Configuration(eid).Execution(ex5).setEndDate(new Date());
        }
                        
                                {
            ex6 = mex.Configuration(eid).addExecution(EnumExecutionsType.OVERALL, EnumPhases.TEST);
           // mex.Configuration(eid).setExecutionId(0, ex1);

            mex.Configuration(eid).Execution(ex6).setStartDate(new Date());
            mex.Configuration(eid).Execution(ex6).setAlgorithm(mex.Configuration(eid).addAlgorithm(EnumAlgorithms.AdaBoostM1));
            //mex.Configuration(eid).Execution(ex1).setStartsAtPosition("1233");
           // mex.Configuration(eid).Execution(ex1).setEndsAtPosition("1376");
            mex.Configuration(eid).Execution(ex6).addPerformance(EnumMeasures.RECALL, .644);
            mex.Configuration(eid).Execution(ex6).addPerformance(EnumMeasures.PRECISION, .7483);
            mex.Configuration(eid).Execution(ex6).addPerformance(EnumMeasures.FMEASURE, .6904);
            mex.Configuration(eid).Execution(ex6).addPerformance(EnumMeasures.ERROR, 3.38);
            mex.Configuration(eid).Execution(ex6).addPerformance(EnumMeasures.MATTHEWSCORRELATIONCOEFICIENT, .675);
          
                //your models call here !
            mex.Configuration(eid).Execution(ex6).setEndDate(new Date());
        }

                                        {
            ex7 = mex.Configuration(eid).addExecution(EnumExecutionsType.OVERALL, EnumPhases.TEST);
           // mex.Configuration(eid).setExecutionId(0, ex1);

            mex.Configuration(eid).Execution(ex7).setStartDate(new Date());
            mex.Configuration(eid).Execution(ex7).setAlgorithm(mex.Configuration(eid).addAlgorithm(EnumAlgorithms.BaggingJ48));
            //mex.Configuration(eid).Execution(ex1).setStartsAtPosition("1233");
           // mex.Configuration(eid).Execution(ex1).setEndsAtPosition("1376");
            mex.Configuration(eid).Execution(ex7).addPerformance(EnumMeasures.RECALL, .6106);
            mex.Configuration(eid).Execution(ex7).addPerformance(EnumMeasures.PRECISION, .7619);
            mex.Configuration(eid).Execution(ex7).addPerformance(EnumMeasures.FMEASURE, .6746);
            mex.Configuration(eid).Execution(ex7).addPerformance(EnumMeasures.ERROR, 3.34);
            mex.Configuration(eid).Execution(ex7).addPerformance(EnumMeasures.MATTHEWSCORRELATIONCOEFICIENT, .663);

                //your models call here !
            mex.Configuration(eid).Execution(ex7).setEndDate(new Date());
        }
                                        
                                                {
           ex8 =  mex.Configuration(eid).addExecution(EnumExecutionsType.OVERALL, EnumPhases.TEST);
           // mex.Configuration(eid).setExecutionId(0, ex1);

            mex.Configuration(eid).Execution(ex8).setStartDate(new Date());
            mex.Configuration(eid).Execution(ex8).setAlgorithm(mex.Configuration(eid).addAlgorithm(EnumAlgorithms.NER_ILLINOIS_EXTENDED));
            //mex.Configuration(eid).Execution(ex1).setStartsAtPosition("1233");
           // mex.Configuration(eid).Execution(ex1).setEndsAtPosition("1376");
            mex.Configuration(eid).Execution(ex8).addPerformance(EnumMeasures.RECALL, .6964);
            mex.Configuration(eid).Execution(ex8).addPerformance(EnumMeasures.PRECISION, .6056);
            mex.Configuration(eid).Execution(ex8).addPerformance(EnumMeasures.FMEASURE, .6444);
            mex.Configuration(eid).Execution(ex8).addPerformance(EnumMeasures.ERROR, 5.09);
            mex.Configuration(eid).Execution(ex8).addPerformance(EnumMeasures.MATTHEWSCORRELATIONCOEFICIENT, .621);

                //your models call here !
            mex.Configuration(eid).Execution(ex8).setEndDate(new Date());
        }
                                                
                                                        {
            ex9 = mex.Configuration(eid).addExecution(EnumExecutionsType.OVERALL, EnumPhases.TEST);
           // mex.Configuration(eid).setExecutionId(0, ex1);

            mex.Configuration(eid).Execution(ex9).setStartDate(new Date());
            mex.Configuration(eid).Execution(ex9).setAlgorithm(mex.Configuration(eid).addAlgorithm(EnumAlgorithms.LogisticModelTrees));
            //mex.Configuration(eid).Execution(ex1).setStartsAtPosition("1233");
           // mex.Configuration(eid).Execution(ex1).setEndsAtPosition("1376");
            mex.Configuration(eid).Execution(ex9).addPerformance(EnumMeasures.RECALL, .6339);
            mex.Configuration(eid).Execution(ex9).addPerformance(EnumMeasures.PRECISION, .7424);
            mex.Configuration(eid).Execution(ex9).addPerformance(EnumMeasures.FMEASURE, .6804);
            mex.Configuration(eid).Execution(ex9).addPerformance(EnumMeasures.ERROR, 3.43);
            mex.Configuration(eid).Execution(ex9).addPerformance(EnumMeasures.MATTHEWSCORRELATIONCOEFICIENT, 0.666);
                //your models call here !
            mex.Configuration(eid).Execution(ex9).setEndDate(new Date());
        }
                                                        
                                                                {
            ex10 = mex.Configuration(eid).addExecution(EnumExecutionsType.OVERALL, EnumPhases.TEST);
           // mex.Configuration(eid).setExecutionId(0, ex1);

            mex.Configuration(eid).Execution(ex10).setStartDate(new Date());
            mex.Configuration(eid).Execution(ex10).setAlgorithm(mex.Configuration(eid).addAlgorithm(EnumAlgorithms.NER_OPEN_NLP));
            //mex.Configuration(eid).Execution(ex1).setStartsAtPosition("1233");
           // mex.Configuration(eid).Execution(ex1).setEndsAtPosition("1376");
            mex.Configuration(eid).Execution(ex10).addPerformance(EnumMeasures.RECALL, .4571);
            mex.Configuration(eid).Execution(ex10).addPerformance(EnumMeasures.PRECISION, .5881);
            mex.Configuration(eid).Execution(ex10).addPerformance(EnumMeasures.FMEASURE, .4918);
            mex.Configuration(eid).Execution(ex10).addPerformance(EnumMeasures.ERROR, 5.93);
            mex.Configuration(eid).Execution(ex10).addPerformance(EnumMeasures.MATTHEWSCORRELATIONCOEFICIENT, 0.477);

                //your models call here !
            mex.Configuration(eid).Execution(ex10).setEndDate(new Date());
        }
                                                                
                                                                       {
            ex11 = mex.Configuration(eid).addExecution(EnumExecutionsType.OVERALL, EnumPhases.TEST);
           // mex.Configuration(eid).setExecutionId(0, ex1);

            mex.Configuration(eid).Execution(ex11).setStartDate(new Date());
            mex.Configuration(eid).Execution(ex11).setAlgorithm(mex.Configuration(eid).addAlgorithm(EnumAlgorithms.MultilayerPerceptron));
            //mex.Configuration(eid).Execution(ex1).setStartsAtPosition("1233");
           // mex.Configuration(eid).Execution(ex1).setEndsAtPosition("1376");
            mex.Configuration(eid).Execution(ex11).addPerformance(EnumMeasures.RECALL, .6386);
            mex.Configuration(eid).Execution(ex11).addPerformance(EnumMeasures.PRECISION, .7511);
            mex.Configuration(eid).Execution(ex11).addPerformance(EnumMeasures.FMEASURE, .6881);
            mex.Configuration(eid).Execution(ex11).addPerformance(EnumMeasures.ERROR, 3.31);
            mex.Configuration(eid).Execution(ex11).addPerformance(EnumMeasures.MATTHEWSCORRELATIONCOEFICIENT, 0.674);

                //your models call here !
            mex.Configuration(eid).Execution(ex11).setEndDate(new Date());
        }
                                                                       
                                                                               {
            ex12 = mex.Configuration(eid).addExecution(EnumExecutionsType.OVERALL, EnumPhases.TEST);
           // mex.Configuration(eid).setExecutionId(0, ex1);

            mex.Configuration(eid).Execution(ex12).setStartDate(new Date());
            mex.Configuration(eid).Execution(ex12).setAlgorithm(mex.Configuration(eid).addAlgorithm(EnumAlgorithms.ClassLevelVoting));
            //mex.Configuration(eid).Execution(ex1).setStartsAtPosition("1233");
           // mex.Configuration(eid).Execution(ex1).setEndsAtPosition("1376");
            mex.Configuration(eid).Execution(ex12).addPerformance(EnumMeasures.RECALL, .6316);
            mex.Configuration(eid).Execution(ex12).addPerformance(EnumMeasures.PRECISION, .7354);
            mex.Configuration(eid).Execution(ex12).addPerformance(EnumMeasures.FMEASURE, .6766);
            mex.Configuration(eid).Execution(ex12).addPerformance(EnumMeasures.ERROR, 3.49);
            mex.Configuration(eid).Execution(ex12).addPerformance(EnumMeasures.MATTHEWSCORRELATIONCOEFICIENT, .662);

                //your models call here !
            mex.Configuration(eid).Execution(ex12).setEndDate(new Date());
        }
                                                                               
                                                                                       {
            ex13 = mex.Configuration(eid).addExecution(EnumExecutionsType.OVERALL, EnumPhases.TEST);
           // mex.Configuration(eid).setExecutionId(0, ex1);

            mex.Configuration(eid).Execution(ex13).setStartDate(new Date());
            mex.Configuration(eid).Execution(ex13).setAlgorithm(mex.Configuration(eid).addAlgorithm(EnumAlgorithms.J48));
            //mex.Configuration(eid).Execution(ex1).setStartsAtPosition("1233");
           // mex.Configuration(eid).Execution(ex1).setEndsAtPosition("1376");
            mex.Configuration(eid).Execution(ex13).addPerformance(EnumMeasures.RECALL, .6211);
            mex.Configuration(eid).Execution(ex13).addPerformance(EnumMeasures.PRECISION, .7378);
            mex.Configuration(eid).Execution(ex13).addPerformance(EnumMeasures.FMEASURE, .6721);
            mex.Configuration(eid).Execution(ex13).addPerformance(EnumMeasures.ERROR, 3.49);
            mex.Configuration(eid).Execution(ex13).addPerformance(EnumMeasures.MATTHEWSCORRELATIONCOEFICIENT, .658);

                //your models call here !
            mex.Configuration(eid).Execution(ex13).setEndDate(new Date());
        }
                                                                                       
                                                                                               {
           ex14 =  mex.Configuration(eid).addExecution(EnumExecutionsType.OVERALL, EnumPhases.TEST);
           // mex.Configuration(eid).setExecutionId(0, ex1);

            mex.Configuration(eid).Execution(ex14).setStartDate(new Date());
            mex.Configuration(eid).Execution(ex14).setAlgorithm(mex.Configuration(eid).addAlgorithm(EnumAlgorithms.NER_STANFORD));
            //mex.Configuration(eid).Execution(ex1).setStartsAtPosition("1233");
           // mex.Configuration(eid).Execution(ex1).setEndsAtPosition("1376");
            mex.Configuration(eid).Execution(ex14).addPerformance(EnumMeasures.RECALL, .6057);
            mex.Configuration(eid).Execution(ex14).addPerformance(EnumMeasures.PRECISION, .7219);
            mex.Configuration(eid).Execution(ex14).addPerformance(EnumMeasures.FMEASURE, .6581);
            mex.Configuration(eid).Execution(ex14).addPerformance(EnumMeasures.ERROR, 3.51);
            mex.Configuration(eid).Execution(ex14).addPerformance(EnumMeasures.MATTHEWSCORRELATIONCOEFICIENT, .643);

                //your models call here !
            mex.Configuration(eid).Execution(ex14).setEndDate(new Date());
        }
                                                                                               
                                                                                                       {
            ex15 = mex.Configuration(eid).addExecution(EnumExecutionsType.OVERALL, EnumPhases.TEST);
           // mex.Configuration(eid).setExecutionId(0, ex1);

            mex.Configuration(eid).Execution(ex15).setStartDate(new Date());
            mex.Configuration(eid).Execution(ex15).setAlgorithm(mex.Configuration(eid).addAlgorithm(EnumAlgorithms.SupportVectorMachines));
            //mex.Configuration(eid).Execution(ex1).setStartsAtPosition("1233");
           // mex.Configuration(eid).Execution(ex1).setEndsAtPosition("1376");
            mex.Configuration(eid).Execution(ex15).addPerformance(EnumMeasures.RECALL, .6294);
            mex.Configuration(eid).Execution(ex15).addPerformance(EnumMeasures.PRECISION, .7345);
            mex.Configuration(eid).Execution(ex15).addPerformance(EnumMeasures.FMEASURE, .676);
            mex.Configuration(eid).Execution(ex15).addPerformance(EnumMeasures.ERROR, 3.49);
            mex.Configuration(eid).Execution(ex15).addPerformance(EnumMeasures.MATTHEWSCORRELATIONCOEFICIENT, .661);

                //your models call here !
            mex.Configuration(eid).Execution(ex15).setEndDate(new Date());
        }
                                                                                                       
                                                                                                               {
            ex16 = mex.Configuration(eid).addExecution(EnumExecutionsType.OVERALL, EnumPhases.TEST);
           // mex.Configuration(eid).setExecutionId(0, ex1);

            mex.Configuration(eid).Execution(ex16).setStartDate(new Date());
            mex.Configuration(eid).Execution(ex16).setAlgorithm(mex.Configuration(eid).addAlgorithm(EnumAlgorithms.NER_BALIE));
            //mex.Configuration(eid).Execution(ex1).setStartsAtPosition("1233");
           // mex.Configuration(eid).Execution(ex1).setEndsAtPosition("1376");
            mex.Configuration(eid).Execution(ex16).addPerformance(EnumMeasures.RECALL, .3863);
            mex.Configuration(eid).Execution(ex16).addPerformance(EnumMeasures.PRECISION, .4383);
            mex.Configuration(eid).Execution(ex16).addPerformance(EnumMeasures.FMEASURE, .4015);
            mex.Configuration(eid).Execution(ex16).addPerformance(EnumMeasures.ERROR, 7.02);
            mex.Configuration(eid).Execution(ex16).addPerformance(EnumMeasures.MATTHEWSCORRELATIONCOEFICIENT, .371);

                //your models call here !
            mex.Configuration(eid).Execution(ex16).setEndDate(new Date());
        }

                                                                                                                       {
           ex17 =  mex.Configuration(eid).addExecution(EnumExecutionsType.OVERALL, EnumPhases.TEST);
           // mex.Configuration(eid).setExecutionId(0, ex1);

            mex.Configuration(eid).Execution(ex17).setStartDate(new Date());
            mex.Configuration(eid).Execution(ex17).setAlgorithm(mex.Configuration(eid).addAlgorithm(EnumAlgorithms.FunctionalTrees));
            //mex.Configuration(eid).Execution(ex1).setStartsAtPosition("1233");
           // mex.Configuration(eid).Execution(ex1).setEndsAtPosition("1376");
            mex.Configuration(eid).Execution(ex17).addPerformance(EnumMeasures.RECALL, .6298);
            mex.Configuration(eid).Execution(ex17).addPerformance(EnumMeasures.PRECISION, .7547);
            mex.Configuration(eid).Execution(ex17).addPerformance(EnumMeasures.FMEASURE, .6825);
            mex.Configuration(eid).Execution(ex17).addPerformance(EnumMeasures.ERROR, 3.33);
            mex.Configuration(eid).Execution(ex17).addPerformance(EnumMeasures.MATTHEWSCORRELATIONCOEFICIENT, 0.67);

                //your models call here !
            mex.Configuration(eid).Execution(ex17).setEndDate(new Date());
        }
                                                                                                                               {
            ex18 = mex.Configuration(eid).addExecution(EnumExecutionsType.OVERALL, EnumPhases.TEST);
           // mex.Configuration(eid).setExecutionId(0, ex1);

            mex.Configuration(eid).Execution(ex18).setStartDate(new Date());
            mex.Configuration(eid).Execution(ex18).setAlgorithm(mex.Configuration(eid).addAlgorithm(EnumAlgorithms.RandomForest));
            //mex.Configuration(eid).Execution(ex1).setStartsAtPosition("1233");
           // mex.Configuration(eid).Execution(ex1).setEndsAtPosition("1376");
            mex.Configuration(eid).Execution(ex18).addPerformance(EnumMeasures.RECALL, .6436);
            mex.Configuration(eid).Execution(ex18).addPerformance(EnumMeasures.PRECISION, .7457);
            mex.Configuration(eid).Execution(ex18).addPerformance(EnumMeasures.FMEASURE, .6893);
            mex.Configuration(eid).Execution(ex18).addPerformance(EnumMeasures.ERROR, 3.338);
            mex.Configuration(eid).Execution(ex18).addPerformance(EnumMeasures.MATTHEWSCORRELATIONCOEFICIENT, .674);

                //your models call here !
            mex.Configuration(eid).Execution(ex18).setEndDate(new Date());
        }
                                                                                                                                       {
            ex19 = mex.Configuration(eid).addExecution(EnumExecutionsType.OVERALL, EnumPhases.TEST);
           // mex.Configuration(eid).setExecutionId(0, ex1);

            mex.Configuration(eid).Execution(ex19).setStartDate(new Date());
            mex.Configuration(eid).Execution(ex19).setAlgorithm(mex.Configuration(eid).addAlgorithm(EnumAlgorithms.LogisticRegression));
            //mex.Configuration(eid).Execution(ex1).setStartsAtPosition("1233");
           // mex.Configuration(eid).Execution(ex1).setEndsAtPosition("1376");
            mex.Configuration(eid).Execution(ex19).addPerformance(EnumMeasures.RECALL, .6031);
            mex.Configuration(eid).Execution(ex19).addPerformance(EnumMeasures.PRECISION, .7789);
            mex.Configuration(eid).Execution(ex19).addPerformance(EnumMeasures.FMEASURE, .675);
            mex.Configuration(eid).Execution(ex19).addPerformance(EnumMeasures.ERROR, 3.39);
            mex.Configuration(eid).Execution(ex19).addPerformance(EnumMeasures.MATTHEWSCORRELATIONCOEFICIENT, .666);

                //your models call here !
            mex.Configuration(eid).Execution(ex19).setEndDate(new Date());
        }
                                                                                                                                       
            try{
                MEXSerializer.getInstance().saveToDisk("../metafiles/log4mex/fox/token/2", "http://mex.aksw.org/examples/", mex, MEXConstant.EnumRDFFormats.TTL);
            }catch (Exception e){
                System.out.print(e.toString());
            }

            System.out.println("The MEX file has been successfully created: share it ;-)");

        System.exit(0);

        }catch (Exception e){
            System.out.println(e.toString());
        }


    }

}
