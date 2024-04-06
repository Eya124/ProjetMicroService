import { Component, OnInit } from '@angular/core';
import {Reclamation} from "../models/Reclamation";
import {ReclamationService} from "../services/reclamation.service";

@Component({
  selector: 'app-reclamation',
  templateUrl: './reclamation.component.html',
  styleUrls: ['./reclamation.component.scss']
})
export class ReclamationComponent implements OnInit {
  reclamations: Reclamation[];

  constructor(private reclamationService: ReclamationService) { }

  ngOnInit(): void {
    this.loadReclamations();
  }

  loadReclamations() {
    this.reclamationService.getAllReclamations().subscribe(reclamations => {
      this.reclamations = reclamations;
    });
  }

}
