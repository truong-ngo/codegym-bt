public class Demo {
    public static void main(String[] args) {
        /*
        SimpleCircle circle1 = new SimpleCircle();
        System.out.println("The area of the circle of radius " + circle1.radius + " is " + circle1.getArea());
        SimpleCircle circle2 = new SimpleCircle(10);
        System.out.println("The area of the circle of radius " + circle2.radius + " is " + circle2.getArea());
        SimpleCircle circle3 = new SimpleCircle(20);
        System.out.println("The area of the circle of radius " + circle3.radius + " is " + circle3.getArea());
        circle2.setRadius(15);
        System.out.println("The area of the circle of radius " + circle2.radius + " is " + circle2.getArea());
        */

        TV tv1 = new TV();
        tv1.turnOn();
        tv1.setChanel(10);
        tv1.setVolume(5);
        System.out.println("tv1's channel is: " + tv1.channel + " and volume level is " + tv1.volume);
        TV tv2 = new TV();
        tv2.turnOn();
        tv2.setChanel(20);
        tv2.setVolume(7);
        System.out.println("tv2's channel is: " + tv2.channel + " and volume level is " + tv2.volume);
    }
    public class SimpleCircle {
        double radius;
        SimpleCircle() {
            radius = 1;
        }
        SimpleCircle (double newRadius) {
            radius = newRadius;
        }
        double getArea() {
            return radius * radius * Math.PI;
        }
        double getPerimeter() {
            return 2 * radius * Math.PI;
        }
        void setRadius(double newRadius) {
            radius = newRadius;
        }
    }
    public static class TV {
        int channel = 1;
        int volume = 1;
        boolean on = false;
        public TV() {};
        public void turnOn() {
            on = true;
        }
        public void turnOff() {
            on = false;
        }
        public void setChanel(int newChanel) {
            if (on && newChanel >= 1 && newChanel <= 100) {
                channel = newChanel;
            }
        }
        public void setVolume(int newVolume) {
            if (on && newVolume >= 1 && newVolume <= 10) {
                volume = newVolume;
            }
        }
        public void channelUp() {
            if (on && channel < 100)
                channel++;
        }

        public void channelDown() {
            if (on && channel > 1)
                channel--;
        }

        public void volumeUp() {
            if (on && volume < 10)
                volume++;
        }

        public void volumeDown() {
            if (on && volume > 1)
                volume--;
        }
    }
}