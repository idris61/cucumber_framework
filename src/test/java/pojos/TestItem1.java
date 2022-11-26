package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TestItem1 {

    /*
    CTestItem{Jump to definition
        createdBy	string
        createdDate	string($date-time)
        defaultValMax	string
        defaultValMin	string
        description	string
        id	integer($int64)
        name	string
        price*	number
        */


        private String defaultValMax;
        private String defaultValMin;
        private String description;
        //private int id;
        private String name;
        private int price;

        public TestItem1() {
        }



        public String getDefaultValMax() {
            return defaultValMax;
        }

        public void setDefaultValMax(String defaultValMax) {
            this.defaultValMax = defaultValMax;
        }

        public String getDefaultValMin() {
            return defaultValMin;
        }

        public void setDefaultValMin(String defaultValMin) {
            this.defaultValMin = defaultValMin;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        @Override
        public String toString() {
            return "CTestItem{" +

                    ", defaultValMax='" + defaultValMax + '\'' +
                    ", defaultValMin='" + defaultValMin + '\'' +
                    ", description='" + description + '\'' +
                    //", id=" + id +
                    ", name='" + name + '\'' +
                    ", price='" + price + '\'' +
                    '}';
        }
    }




