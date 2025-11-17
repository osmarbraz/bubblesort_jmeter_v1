
import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;
import org.apache.jmeter.config.Arguments;

public class TesteJMeter extends AbstractJavaSamplerClient {

    public Arguments getDefaultParameters() {
        Arguments defaultParameters = new Arguments();
        defaultParameters.addArgument("QUANTIDADE", "100");
        defaultParameters.addArgument("INTERVALO", "100");
        return defaultParameters;
    }

    public SampleResult runTest(JavaSamplerContext context) {
        SampleResult result = new SampleResult();
        result.setSampleLabel("Teste do Bubblesort");
        String quantidadeString = context.getParameter("QUANTIDADE");
        String intervaloString = context.getParameter("INTERVALO");
        result.setDataType(SampleResult.TEXT);
        result.sampleStart();
        try {
            new Principal().classificar(Integer.parseInt(quantidadeString), Integer.parseInt(intervaloString));

            result.sampleEnd();
            result.setSuccessful(true);
            result.setResponseCodeOK(); //200 
            result.setResponseMessageOK();

            return result;
        } catch (Exception e) {
            result.sampleEnd();
            result.setSuccessful(false);
            result.setResponseCode("500"); //Erro
            result.setResponseMessage(e.getMessage());
        }
        return result;
    }
}
