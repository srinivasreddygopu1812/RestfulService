package com.cricbuzz.score.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.cricbuzz.dbutil.DbUtil;
import com.cricbuzz.score.pojo.ScorePojo;
import com.cricbuzz.score.pojo.Team;

@Path("/ipl")
public class ScoreService {

	@Path("/test")
	@GET
	public Response test() {
		System.out.println("test connection successfull");

		return Response.status(200).entity("success").build();
	}

	@Path("/testAgain")
	@GET
	public Response testAgain() {
		System.out.println("testAgain connection successfull");

		return Response.status(201).entity("success again").build();
	}

	@Path("/getScore")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getScore() {
SessionFactory sf = DbUtil.getSessionFactory();
Session sn = sf.openSession();
Query qr = sn.createQuery("from ScorePojo");
List<ScorePojo> list = qr.list();
ScorePojo scr =   list.get(0);
	
		

		return Response.status(200).entity(scr).build();
	}


	@Path("/registerTeam")
	@POST
	@Consumes(MediaType.APPLICATION_JSON) // to take data from client in json format
	@Produces(MediaType.APPLICATION_JSON) // to return data to client from teamRegister service in json format
	public Response teamRegister(Team team) {
		System.out.println("in teamRegister service ");
		 
		Double winningPercentage=team.getWins() / team.getTotalMatches() * 100;
		System.out.println(winningPercentage);
		if (winningPercentage >= 50) {
			team.setStatus("Accepted");
		}

		return Response.status(201).entity(team).build();

	}

}

/*@Path("/scoreGetter")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response scoreGetter() {

		ScorePojo scr = new ScorePojo();
		scr.setRuns(325);
		scr.setWickets(5);
		scr.setOvers(41);
		scr.setBat1("Virat");
		scr.setBat2("Dhoni");
		scr.setCountry("India");

		return Response.status(201).entity(scr).build();
	}*/