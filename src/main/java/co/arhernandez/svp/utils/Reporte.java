package co.arhernandez.svp.utils;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import java.io.File;
import net.serenitybdd.screenplay.Performable;
import net.thucydides.core.model.TestStep;
import net.thucydides.core.screenshots.ScreenshotAndHtmlSource;
import net.thucydides.core.steps.ExecutedStepDescription;
import net.thucydides.core.steps.StepEventBus;

public class Reporte {

  private String nombrePaso;

  public Reporte(String nombrePaso) {
    this.nombrePaso = nombrePaso;
  }

  public static Reporte crearPaso(String nombrePaso) {
    return new Reporte(nombrePaso);
  }

  public static void modificarDescripcionUltimoPasoPorTexto(String descripcion) {
    ultimoPaso().addScreenshot(new ScreenshotAndHtmlSource(new File("evidencia.png")));
    ultimoPaso().setDescription(theActorInTheSpotlight().getName() + " " + descripcion);
  }

  public static TestStep ultimoPaso() {
    return StepEventBus.getEventBus()
        .getCurrentStep()
        .get()
        .getChildren()
        .get(StepEventBus.getEventBus().getCurrentStep().get().getChildren().size() - 1);
  }

  public static String estadoUltimoPaso() {
    return ultimoPaso().getResult().name();
  }

  public static String estructurarLista(String lista) {
    return lista.replace(",", "\n").replaceAll("[^A-Za-z0-9\n: ]", "");
  }

  public void conLasAcciones(Performable... task) {
    StepEventBus.getEventBus().stepStarted(ExecutedStepDescription.withTitle(nombrePaso));
    theActorInTheSpotlight().attemptsTo(task);
    StepEventBus.getEventBus().stepFinished();
  }
}
