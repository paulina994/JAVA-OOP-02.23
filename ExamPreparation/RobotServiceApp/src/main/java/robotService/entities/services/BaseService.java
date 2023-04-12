package robotService.entities.services;

import robotService.common.ConstantMessages;
import robotService.common.ExceptionMessages;
import robotService.entities.robot.Robot;
import robotService.entities.supplements.Supplement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public abstract class BaseService implements Service {

    private String name;
    private int capacity;
    private Collection<Supplement> supplements;
    private Collection<Robot> robots;

    public BaseService(String name, int capacity) {
        this.setName(name);
        this.capacity = capacity;
        supplements = new ArrayList<>();
        robots = new ArrayList<>();
    }


    @Override
    public void removeRobot(Robot robot) {
        this.getRobots().remove(robot);
    }

    @Override
    public void addSupplement(Supplement supplement) {
        this.getSupplements().add(supplement);
        }


    @Override
    public void feeding() {
        for (Robot robot : robots) {
            robot.eating();
        }
    }

    @Override
    public String getStatistics() {

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s %s:", this.name, this.getClass().getSimpleName()))
                .append(System.lineSeparator());
        String report = robots.isEmpty()
                ? "none"
                : robots.stream()
                .map(Robot::getName)
                .collect(Collectors.joining(" "));
        sb.append(String.format("Robots: %s", report))
                .append(System.lineSeparator());

        long suplementsSize = supplements.stream().count();
        sb.append(String.format("Supplements: %d Hardness: %d", suplementsSize, this.sumHardness()))
                .append(System.lineSeparator());
        return sb.toString().trim();
    }
    @Override
    public void addRobot(Robot robot) {
        if (this.getRobots().size() >= this.capacity) {
            throw new IllegalStateException(ConstantMessages.NOT_ENOUGH_CAPACITY_FOR_ROBOT);
        } else {
            this.getRobots().add(robot);
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        if(name == null || name.trim().isEmpty()){
            throw new NullPointerException(ExceptionMessages.SERVICE_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.name = name;
    }




    @Override
    public Collection<Supplement> getSupplements() {
        return supplements;
    }


    @Override
    public Collection<Robot> getRobots() {
        return robots;
    }


    @Override
    public int sumHardness() {
        int sum = 0;
        for (Supplement supplement : this.getSupplements()) {
            sum += supplement.getHardness();
        }
        return sum;
    }
}
