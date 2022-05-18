class ParkingSystem {
    int parkingspace[]=new int[3];

    public ParkingSystem(int big, int medium, int small) {
        parkingspace[0]=big;
        parkingspace[1]=medium;
        parkingspace[2]=small;
    }
    
    public boolean addCar(int carType) {
        if(parkingspace[carType-1]<=0)
            return false;
        parkingspace[carType-1]--;
        return true;
        
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */