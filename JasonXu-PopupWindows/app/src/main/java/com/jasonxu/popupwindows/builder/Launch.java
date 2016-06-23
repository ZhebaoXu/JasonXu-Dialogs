package com.jasonxu.popupwindows.builder;

/**
 * Created by t_xuz on 6/23/16.
 */
public class Launch {

    private String cake;
    private String meat;
    private String milk;
    private String drink;

    private Launch(Builder builder){
        this.cake = builder.cake;
        this.meat = builder.meat;
        this.milk = builder.milk;
        this.drink = builder.drink;
    }

    @Override
    public String toString() {
        return "Launch{" +
                "cake='" + cake + '\'' +
                ", meat='" + meat + '\'' +
                ", milk='" + milk + '\'' +
                ", drink='" + drink + '\'' +
                '}';
    }

    public static class Builder{

        private String cake; //必须要实现
        private String meat;
        private String milk;
        private String drink;

        public Builder(String cake){
            this.cake = cake;
        }

        public Builder addMeat(String meat){
            this.meat = meat;
            return this;
        }

        public Builder addMilk(String milk){
            this.milk = milk;
            return this;
        }

        public Builder addDrink(String drink){
            this.drink = drink;
            return this;
        }

        public Launch create(){
            return new Launch(this);
        }

    }

    public static void main(String args[]){
        Launch.Builder builder = new Launch.Builder("卡琪琳");
        Launch launch = builder.addDrink("果汁")
                .addMeat("牛肉")
                .addMilk("牛奶")
                .create();

        System.out.println("launch---" + launch.toString());
    }
}
