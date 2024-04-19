import repositories.ContRepository;
import repositories.IRepository;
import services.Service;
import ui.UI;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        IRepository repository = new ContRepository();
        Service service = new Service(repository);
        UI ui = new UI(service);

        ui.run();

    }
}