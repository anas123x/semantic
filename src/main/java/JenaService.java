import org.apache.jena.query.*;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.springframework.stereotype.Service;

@Service
public class JenaService {
    public void queryRdfData() {
        Model model = ModelFactory.createDefaultModel();
        model.read("path/to/your/rdf/file.rdf");

        String sparqlQuery = "SELECT ?subject WHERE { ?subject ?predicate ?object }";
        Query query = QueryFactory.create(sparqlQuery);
        try (QueryExecution qexec = QueryExecutionFactory.create(query, model)) {
            ResultSet results = qexec.execSelect();
            while (results.hasNext()) {
                QuerySolution soln = results.nextSolution();
                System.out.println(soln.get("subject"));
            }
        }
    }
}
