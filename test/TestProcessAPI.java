import process.api.ProcessAPI;
import org.mockito.Mockito;

public class ProcessAPITests {
	private ProcessAPI mockProcApi = mock(ProcessAPI.class);
	private ProcessAPIImpl procApi = new ProcessAPIImpl(mockProcAPI);
	//I cannot get any mockito or Junit methods to be recognized within this class
	//ProcessAPI depends on an object of DSS and CE
	@Test
	public void testDSS()
	{
		Assertions.assertEquals();
	}
	@Test
	public void testCE()
	{}
}