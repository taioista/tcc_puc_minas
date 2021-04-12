import { Component } from "@angular/core";
import { ActivatedRoute } from "@angular/router";
import { Norma } from "../model/model";
import { NormaService } from "../service/norma.service";

@Component({
  selector: "app-detalhaNorma",
  templateUrl: "./detalhaNorma.component.html",
  styleUrls: ["./detalhaNorma.component.css"],
})
export class DetalhaNormaComponent {
  norma: Norma;

  constructor(
    private route: ActivatedRoute,
    private normaService: NormaService
  ) {}

  ngOnInit() {
    this.norma = new Norma();
    const id = this.route.snapshot.params["id"];
    this.getNorma(id);
  }

  getNorma(id) {
    this.normaService.get(id).subscribe((response) => {
      Object.values(response).forEach((norma) => {
        this.norma = norma;
      });
    });
  }
}
