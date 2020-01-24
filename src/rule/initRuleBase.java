/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rule;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hassaine
 */
public class initRuleBase {

    public static void initMedcinRuleBase(BooleanRuleBase rb) {

        System.out.println(rb.name);
        // rule Variable
        RuleVariable maladie = new RuleVariable(rb, "maladie");
        maladie.setLabels(
                "intoxication_alimentaire inflamation_de_lestomac inflamation_des_intistaint hypertermie pharyngitis infection_urinaire");
        maladie.setPromptText("maladie?");

        RuleVariable symptome = new RuleVariable(rb, "symptome");
        symptome.setLabels("hypertermie grippe");
        RuleVariable pert_dappetit = new RuleVariable(rb, "pert_dappetit");
        pert_dappetit.setLabels("yes no");
        pert_dappetit.setPromptText("avez vous une pert d'appetit?");

        RuleVariable fatigue = new RuleVariable(rb, "fatigue");
        fatigue.setLabels("eleve normal");
        fatigue.setPromptText("vous vous senter fatigue?");

        RuleVariable nez_bouchee = new RuleVariable(rb, "nez_bouchee");
        nez_bouchee.setLabels("yes no");
        nez_bouchee.setPromptText("nez_bouchee?");

        RuleVariable douleur_articulaire = new RuleVariable(rb, "douleur_articulaire");
        douleur_articulaire.setLabels("yes no");
        douleur_articulaire.setPromptText("douleur articulaire?");

        RuleVariable hypertermie = new RuleVariable(rb, "hypertermie");
        hypertermie.setLabels("yes no");
        hypertermie.setPromptText("hypertermie?");

        RuleVariable chaleur_dans_les_extrimites_du_corps = new RuleVariable(rb,
                "chaleur_dans_les_extrimites_du_corps");
        chaleur_dans_les_extrimites_du_corps.setLabels("eleve normal");
        chaleur_dans_les_extrimites_du_corps.setPromptText("chaleur dans les extrimites du corps?");

        RuleVariable fievre = new RuleVariable(rb, "fievre");
        fievre.setLabels("yes no");
        fievre.setPromptText("fievre?");

        RuleVariable diarrhee = new RuleVariable(rb, "diarrhee");
        diarrhee.setLabels("yes no");
        diarrhee.setPromptText("diarrhee?");

        RuleVariable vomisement = new RuleVariable(rb, "vomisement");
        vomisement.setLabels("yes no");
        vomisement.setPromptText("vomisement?");

        RuleVariable toux = new RuleVariable(rb, "toux");
        toux.setLabels("yes no");
        toux.setPromptText("toux?");

        RuleVariable coliques_degistifs = new RuleVariable(rb, "coliques_degistifs");
        coliques_degistifs.setLabels("yes no");
        coliques_degistifs.setPromptText("coliques_degistifs?");

        RuleVariable miction_douleureusse = new RuleVariable(rb, "miction_douleureusse");
        miction_douleureusse.setLabels("yes no");
        miction_douleureusse.setPromptText("miction_douleureusse?");

        Condition cEquals = new Condition("=");

        Rule intoxication_alimentaire = new Rule(rb, "intoxAlim",
                new Clause[]{new Clause(fievre, cEquals, "yes"),
                    new Clause(diarrhee, cEquals, "yes"),
                    new Clause(coliques_degistifs, cEquals, "yes")
                },
                new Clause(maladie, cEquals, "intoxication_alimentaire"));
        Rule inflamation_de_lestomac = new Rule(rb, "inflamationIestomac",
                new Clause[]{new Clause(fievre, cEquals, "yes"),
                    new Clause(vomisement, cEquals, "yes")},
                new Clause(maladie, cEquals, "inflamation_de_lestomac"));
        Rule infection_urinaire = new Rule(rb, "infectionUrinaire",
                new Clause[]{new Clause(fievre, cEquals, "yes"),
                    new Clause(miction_douleureusse, cEquals, "yes")},
                new Clause(maladie, cEquals, "infection_urinaire"));
        Rule pharangit = new Rule(rb, "pharangit",
                new Clause[]{new Clause(toux, cEquals, "yes"), new Clause(fievre, cEquals, "yes")
                },
                new Clause(maladie, cEquals, "pharangit"));

        Rule grippeRule = new Rule(rb, "grippeRule", new Clause[]{new Clause(fatigue, cEquals, "eleve"),
            new Clause(nez_bouchee, cEquals, "yes"), new Clause(douleur_articulaire, cEquals, "yes"),
            new Clause(symptome, cEquals, "hypertermie")

        }, new Clause(symptome, cEquals, "grippe"));

        Rule fievreRule = new Rule(rb, "fievreRule",
                new Clause[]{new Clause(pert_dappetit, cEquals, "yes"),
                    new Clause(symptome, cEquals, "grippe")},
                new Clause(fievre, cEquals, "yes"));

        Rule hypertermieRule = new Rule(rb, "hypertermieRule",
                new Clause(chaleur_dans_les_extrimites_du_corps, cEquals, "eleve"),
                new Clause(symptome, cEquals, "hypertermie"));

    }

    public static void initVehiculeRuleBase(BooleanRuleBase rb) {
        RuleVariable vehicule = new RuleVariable(rb, "vehicule");
        vehicule.setLabels("Bicycle Tricycle Motorcycle Sports_car Sedan MiniVan Sport_Utility_vehicule");
        vehicule.setPromptText("what kind of vehicule is it?");

        RuleVariable vehiculeType = new RuleVariable(rb, "vehiculeType");
        vehiculeType.setLabels("cycle automobile");
        vehiculeType.setPromptText("what type of vehicule is it?");

        RuleVariable size = new RuleVariable(rb, "size");
        size.setLabels("small medium large");
        vehiculeType.setPromptText("what  size is of the vehicule?");

        RuleVariable motor = new RuleVariable(rb, "motor");
        size.setLabels("yes no");
        vehiculeType.setPromptText("does the vehicule have a motor?");

        RuleVariable num_wheels = new RuleVariable(rb, "num_wheels");
        size.setLabels("2 3 4");
        vehiculeType.setPromptText("how many wheels does it have?");

        RuleVariable num_doors = new RuleVariable(rb, "num_doors");
        size.setLabels("2 3 4");
        vehiculeType.setPromptText("how many doors does it have?");

        Condition cEquals = new Condition("=");
        Condition cNotEquals = new Condition("!=");
        Condition clessThen = new Condition("<");
        Condition cMoreThen = new Condition(">");

        Rule Bicycle = new Rule(rb, "bicycle", new Clause[]{new Clause(vehiculeType, cEquals, "cycle"),
            new Clause(num_wheels, cEquals, "2"), new Clause(motor, cEquals, "no")},
                new Clause(vehicule, cEquals, "Bicycle"));
        Rule Tricycle = new Rule(rb, "Tricycle", new Clause[]{new Clause(vehiculeType, cEquals, "cycle"),
            new Clause(num_wheels, cEquals, "3"), new Clause(motor, cEquals, "no")},
                new Clause(vehicule, cEquals, "Tricycle"));
        Rule Motorcycle = new Rule(rb, "motorcycle", new Clause[]{new Clause(vehiculeType, cEquals, "cycle"),
            new Clause(num_wheels, cEquals, "2"), new Clause(motor, cEquals, "yes")},
                new Clause(vehicule, cEquals, "Motorcycle"));

        Rule SportsCar = new Rule(rb, "sportsCar",
                new Clause[]{new Clause(vehiculeType, cEquals, "automobile"),
                    new Clause(num_doors, cEquals, "2"),
                    new Clause(size, cEquals, "small")},
                new Clause(vehicule, cEquals, "Sports_car"));
        Rule Sedan = new Rule(rb, "sedan", new Clause[]{new Clause(vehiculeType, cEquals, "automobile"),
            new Clause(num_doors, cEquals, "4"), new Clause(size, cEquals, "medium")},
                new Clause(vehicule, cEquals, "Sedan"));
        Rule MiniVan = new Rule(rb, "miniVan", new Clause[]{new Clause(vehiculeType, cEquals, "automobile"),
            new Clause(num_doors, cEquals, "3"), new Clause(size, cEquals, "medium")},
                new Clause(vehicule, cEquals, "MiniVan"));
        Rule SUV = new Rule(rb, "SUV", new Clause[]{new Clause(vehiculeType, cEquals, "automobile"),
            new Clause(num_doors, cEquals, "4"), new Clause(size, cEquals, "large")},
                new Clause(vehicule, cEquals, "Sport_Utility_vehicule"));

        Rule Cycle = new Rule(rb, "Cycle", new Clause(num_wheels, clessThen, "4"),
                new Clause(vehiculeType, cEquals, "cycle"));
        Rule Automobile = new Rule(rb, "Automobile",
                new Clause[]{new Clause(num_wheels, cEquals, "4"),
                    new Clause(motor, cEquals, "yes")},
                new Clause(vehiculeType, cEquals, "automobile"));

    }

    public static void kBLoader(BooleanRuleBase rb, boolean defaultFlag) {

        System.out.println("setting values for Vehicule forward chaining");
        JsonParser parser = new JsonParser();
        Reader rder;
        try {
            if (defaultFlag) {
                rder = new FileReader("intialKnowledgeBase/" + rb.name + "KB_default.json");
            } else {
                rder = new FileReader("intialKnowledgeBase/" + rb.name + "KB.json");
            }

            JsonElement elemnt = parser.parse(rder);
            JsonObject obj = elemnt.getAsJsonObject();
            Set<String> keys = obj.keySet();
            Iterator<String> element = keys.iterator();

            while (element.hasNext()) {
                String next = element.next();

                rb.setVariableValue(next, obj.get(next).getAsString().equals("null") ? null
                        : obj.get(next).getAsString());
            }

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

}
