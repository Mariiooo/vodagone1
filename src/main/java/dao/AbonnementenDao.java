package dao;

import model.Abonnement;
import model.Abonnementen;

import javax.ws.rs.core.Response;

public class AbonnementenDao {

    public AbonnementenDao(){





    }

    public Response makeAbo(){

        Abonnementen testabbo = new Abonnementen();
        testabbo.addAbonnement(new Abonnement(0, "vodafone", "Mobiele telefonie 100"));
        testabbo.addAbonnement(new Abonnement(1, "vodafone", "Mobiele telefonie 250"));
        testabbo.addAbonnement(new Abonnement(2, "ziggo", "Kabel-internet (download 300 Mbps"));


        return Response.ok().build();

    }






}
