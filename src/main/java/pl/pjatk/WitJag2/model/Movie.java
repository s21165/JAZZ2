package pl.pjatk.WitJag2.model;


    public class Movie {
        private Long id;
        private String name;
        private String category;

        public Movie(Long id, String name, String category) {
            this.id = id;
            this.name = name;
            this.category = category;
        }



        public String getName() {
            return name;
        }

        public String getCategory() {
            return category;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setCategory(String category) {
            this.category = category;
        }



    }

