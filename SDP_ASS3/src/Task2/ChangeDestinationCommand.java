package Task2;

public class ChangeDestinationCommand implements Command {
    private TaxiService service;
    private String newDestination;

    public ChangeDestinationCommand(TaxiService service, String newDestination) {
        this.service = service;
        this.newDestination = newDestination;
    }

    @Override
    public void execute() {
        service.changeDestination(newDestination);
    }
}
