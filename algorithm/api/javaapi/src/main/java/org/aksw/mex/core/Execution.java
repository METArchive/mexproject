package org.aksw.mex.core;

import com.google.common.collect.Collections2;
import org.aksw.mex.algo.AlgorithmVO;
import org.aksw.mex.perf.overall.*;
import org.aksw.mex.util.Global;
import org.apache.commons.lang3.EnumUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Created by esteves on 26.06.15.
 */
public abstract class Execution {

    protected String _id;
    protected Boolean _grouped;
    protected Date _startedAtTime;
    protected Date _endedAtTime;
    protected ExperimentConfigurationVO _expConf;
    protected PhaseVO _phase;
    protected AlgorithmVO _algo;
    protected IDataSetExample _example;
    protected List<Measure> _performances;

    public Execution(){
    }

    public String get_id() {
        return _id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }
    public Boolean get_grouped() {
        return _grouped;
    }
    public void set_grouped(Boolean _grouped) {
        this._grouped = _grouped;
    }
    public Date get_startedAtTime() {
        return _startedAtTime;
    }
    public void set_startedAtTime(Date _startedAtTime) {
        this._startedAtTime = _startedAtTime;
    }
    public Date get_endedAtTime() {
        return _endedAtTime;
    }
    public void set_endedAtTime(Date _endedAtTime) {
        this._endedAtTime = _endedAtTime;
    }
    public ExperimentConfigurationVO get_expConf() {
        return _expConf;
    }
    public void set_expConf(ExperimentConfigurationVO _expConf) {
        this._expConf = _expConf;
    }
    public PhaseVO get_phase() {
        return _phase;
    }
    public void set_phase(PhaseVO _phase) {
        this._phase = _phase;
    }
    public AlgorithmVO get_algo() {
        return _algo;
    }
    public void set_algo(AlgorithmVO _algo) {
        this._algo = _algo;
    }
    public IDataSetExample get_example() {
        return _example;
    }
    public void set_example(IDataSetExample _example) {
        this._example = _example;
    }
    public void setId(String value){
        this._id = value;
    }
    public void setStartDate(Date value){
        this._startedAtTime = value;
    }
    public void setEndDate(Date value){
        this._endedAtTime = value;
    }
    public void setExperimentConfiguration(ExperimentConfigurationVO value){
        this._expConf = value;
    }
    public void setAlgorithm(AlgorithmVO value){
        this._algo = value;
    }
    public void setExamples(IDataSetExample value){
        this._example = value;
    }
    public void setPhase(PhaseVO value){
        this._phase = value;
    }

    public boolean addPerformance(String p, double v){
        String type = "";
        boolean ret = false;

            try{
                type = "cla";
                if (EnumUtils.isValidEnum(Global.EnumClassificationMeasure.class, p) == false){
                    type = "reg";
                    if (EnumUtils.isValidEnum(Global.EnumRegressionMeasure.class, p) == false){
                        type = "sta";
                        if (EnumUtils.isValidEnum(Global.EnumStatisticalMeasure.class, p) == false){
                            type = "clu";
                            if (EnumUtils.isValidEnum(Global.EnumClusteringMeasure.class, p) == false){
                                return false;}
                        }
                    }
                }


                switch (type) {
                    case "cla":
                        ret = addClassificationPerformance(p,v);
                        break;
                    case "reg":
                        ret = addRegressionPerformance(p, v);
                        break;
                    case "sta":
                        ret = addStatisticalPerformance(p, v);
                        break;
                    case "clu":
                        ret = addClusteringPerformance(p, v);
                        break;
                    default:
                        ret = false;
                        break;
                }

            }catch (Exception e){
                return false;}

            finally {
                return ret;}

    }


    private boolean addClassificationPerformance(String p, double value) {
        ClassificationMeasureVO m = new ClassificationMeasureVO();
        m.setValue(value);
        m.setName(p);
        return this._performances.add(m);
    }
    private boolean addRegressionPerformance(String p, double value) {
        RegressionMeasureVO m = new RegressionMeasureVO();
        m.setValue(value);
        m.setName(p);
        return this._performances.add(m);
    }
    private boolean addStatisticalPerformance(String p, double value) {
        StatisticalMeasureVO m = new StatisticalMeasureVO();
        m.setValue(value);
        m.setName(p);
        return this._performances.add(m);
    }
    private boolean addClusteringPerformance(String p, double value) {
        ClusteringMeasureVO m = new ClusteringMeasureVO();
        m.setValue(value);
        m.setName(p);
        return this._performances.add(m);
    }

    public List<ClassificationMeasureVO> getClassificationPerformance() {
        List<ClassificationMeasureVO> classifications = null;
        Collection<Measure> t
                = Collections2.filter(this._performances, p -> p instanceof ClassificationMeasureVO);
        if (t != null){
            classifications = new ArrayList(t);
        }
        return classifications;
    }
    public List<Measure> getPerformances() {
        return _performances;
    }

}
