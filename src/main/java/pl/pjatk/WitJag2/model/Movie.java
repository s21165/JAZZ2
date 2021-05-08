package pl.pjatk.WitJag2.model;


    public class Movie {
        private Long id;

        public Movie(long id) {
            this.id = id;

        }

        public Long getId() {
            return id;
        }

        public void setMake(Long id) {
            this.id = id;
        }
    }

