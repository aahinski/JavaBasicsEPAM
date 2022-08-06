package com.epam.rd.autotasks;

public class DecrementingCarousel {

    private CarouselRun carouselRun;
    private boolean launched;
    private int numberOfAdded;
    private int capacity;

    public DecrementingCarousel(int capacity) {
        this.capacity = capacity;
        this.carouselRun = new CarouselRun(capacity);
        launched = false;
    }

    public boolean addElement(int element){
        carouselRun.isNumbersAdded = true;
        if(element <= 0 || this.carouselRun.isFinished() || launched || numberOfAdded == capacity)
            return false;
        else {
            carouselRun.getNumbers()[numberOfAdded] = element;
            int numberOfZeros = carouselRun.getNumberOfZeros();
            carouselRun.setNumberOfZeros(numberOfZeros - 1);
            numberOfAdded++;
            return true;
        }
    }

    public CarouselRun run(){
       if(launched)
           return null;
       else {
           launched = true;
           return this.carouselRun;
       }
    }

    public CarouselRun getCarouselRun() {
        return carouselRun;
    }

    public void setCarouselRun(CarouselRun carouselRun) {
        this.carouselRun = carouselRun;
    }

    public boolean isLaunched() {
        return launched;
    }

    public void setLaunched(boolean launched) {
        this.launched = launched;
    }

    public int getNumberOfAdded() {
        return numberOfAdded;
    }

    public void setNumberOfAdded(int numberOfAdded) {
        this.numberOfAdded = numberOfAdded;
    }
}
