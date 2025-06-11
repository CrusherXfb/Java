package HouseBuilding;


    public class Main {
        public static void main(String[] args) {
            House house = new House();
            Team team = new Team();

            team.addWorker(new Worker());
            team.addWorker(new Worker());
            team.addWorker(new Worker());
            team.addWorker(new TeamLeader());


            team.buildHouse(house);
        }
    }

