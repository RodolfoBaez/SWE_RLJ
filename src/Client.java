import conceptual.api.ComputationalAPI;
import conceptual.api.ComputeEngine;
import coordinator.Coordinator;
import io.grpc.BindableService;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import network.api.NetworkAPI;
import process.api.ProcessAPI;

public class Client {
    private static NetworkAPI networkAPI;
    private static ProcessAPI processAPI;
    private static ComputeEngine computeEngine;
    private static ComputationalAPI computationalAPI;

    public static void main(String[] args) throws Exception {
        // Initialize the required components
        computeEngine = new ComputeEngine(); // Initialize ComputeEngine first
        networkAPI = new NetworkAPI(computeEngine); // Pass computeEngine to NetworkAPI
        processAPI = new ProcessAPI(); // Replace with actual instantiation logic
        computationalAPI = new ComputationalAPI(); // Replace with actual instantiation logic

        // Create and start the gRPC server
        Server server = ServerBuilder.forPort(50051)
                .addService((BindableService) new Coordinator(networkAPI, processAPI, computeEngine, computationalAPI))
                .build()
                .start();

        System.out.println("Server started on port 50051");

        // Wait for the server to terminate
        server.awaitTermination();
    }
}
