package com.epam.rd.autotasks;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        DecrementingCarousel decrementingCarousel = new DecrementingCarousel(7);
        decrementingCarousel.addElement(3);
        System.out.println(Arrays.toString(decrementingCarousel.getCarouselRun().getNumbers()));
        decrementingCarousel.addElement(7);
        System.out.println(Arrays.toString(decrementingCarousel.getCarouselRun().getNumbers()));
        decrementingCarousel.addElement(4);
        System.out.println(Arrays.toString(decrementingCarousel.getCarouselRun().getNumbers()));
        CarouselRun run = decrementingCarousel.run();
        System.out.println(Arrays.toString(decrementingCarousel.getCarouselRun().getNumbers()));
        System.out.println(run.next());
        System.out.println(run.next());
        System.out.println(run.next());
        System.out.println(run.next());
        System.out.println(run.next());
        System.out.println(run.next());
        System.out.println(run.next());
        System.out.println(run.next());
        System.out.println(run.next());
        System.out.println(run.next());
        System.out.println(run.next());
        System.out.println(run.next());
        System.out.println(run.next());
        System.out.println(run.next());
        System.out.println(run.next());
    }
}
