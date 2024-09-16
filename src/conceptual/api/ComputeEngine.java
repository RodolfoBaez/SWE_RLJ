package conceptual.api;

public interface ComputeEngine {
	//from user via network api
    InputSource getInputSrc(ComputeEngine ce);   

    //send output source to dataStorage to be formatted
    OutputSource sendOutputSrc(ComputeEngine ce); 
}
