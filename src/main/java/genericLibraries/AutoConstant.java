package genericLibraries;

public interface AutoConstant {
		
	String postOperation = "/user/repos";
	String getOperation = "/repos/{owner}/{repo}";
	String patchOperation = "/repos/{owner}/{repo}";
	String deleteOperation = "/repos/{owner}/{repo}";
	String propertyFilePath = "./src/test/resources/data.properties";
}
