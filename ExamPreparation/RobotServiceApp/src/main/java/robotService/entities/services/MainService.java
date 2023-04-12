package robotService.entities.services;

public class MainService extends BaseService{
    private static final int MAIN_SERVICE_CAPACITY = 30;

    public MainService(String name) {
        super(name, MAIN_SERVICE_CAPACITY);
    }
}
