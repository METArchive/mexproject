package example;

/**
 * Created by root on 26.06.15.
 */
public class Example4 {

     /*

        FileManager.get().addLocatorClassLoader(Example.class.getClassLoader());
        Model model = FileManager.get().loadModel(Constants.MEX_ALGO_URL, null, "TURTLE");
        StmtIterator iter = model.listStatements();
        Property p1 = model.getProperty(Constants.MEX_ALGO_URL + "dataProperty1");

        try {
            InputStream is;
            //is = new URL(org.aksw.mex.util.Constants.MEX_ALGO_URL).openStream();
            is = new FileInputStream(Constants.TESTE_TTL);


            OntModel ontModel = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
            ontModel.read(is, null, Constants.FILE_FORMAT);

            String base = ontModel.getNsPrefixURI("");

            OntProperty iProperty = ontModel.getOntProperty(base + "dataProperty1");

            System.out.println(iProperty.toString());

            OntClass iClass =ontModel.getOntClass(base + Constants.CLS_IMPLEMENTATION);
            for (ExtendedIterator<? extends OntResource> it= iClass.listInstances(true);it.hasNext();) {
                Individual ins = (Individual) it.next();

                RDFNode iValue = ins.getPropertyValue(iProperty);

                System.out.println(ins.getLocalName());
            }


        }
        catch (Exception e){
            System.out.println(e.toString());
        }


        try {
            while (iter.hasNext()) {
                Statement stmt = iter.next();

                Resource s = stmt.getSubject();
                Resource p = stmt.getPredicate();
                RDFNode o = stmt.getObject();

                //System.out.print(s.toString() + " - ");
                //System.out.print(p.toString() + " - ");
                //System.out.println(o.toString());

            }
        }finally {
            if ( iter != null ) iter.close();
        }
    */

}
