package com.example.centre;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Centre {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private  int id;
        private String name;
        private  String description;
        private  String ville;

        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getDescription() {
                return description;
        }

        public void setDescription(String description) {
                this.description = description;
        }

        public String getVille() {
                return ville;
        }

        public void setVille(String ville) {
                this.ville = ville;
        }
        //   @OneToMany(mappedBy = "centre", cascade =  CascadeType.ALL)
      //  private List<Evenement> evenements;
}
