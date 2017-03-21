/*
 * --------------------------------------------------------------------------------------------------------------
 * -	Exhalia's Java code updated	to craft APIs for Mulsemedia under the NEWTON project		       			-
 * -	Brunel University London																				-
 * -	2017																									-
 * -																											-
 * -	Updates:																								-
 * - 	"Exhalia.jar" - included into the build path of the project												-
 * - 	"Exhalia.dll" - copied eclipse folder and loaded into this project.										-
 * -	Once the program is executed, all fans run turn by turn by setting a delay in between. 					-
 * --------------------------------------------------------------------------------------------------------------
 */

package exhalia_project;
import exhalia.CScentDiffusionContext;

public class TestExhalia_Java_v2 {
	
	public static void main(String[] args) throws InterruptedException{
		
		// Create the diffusion context		
		CScentDiffusionContext diffusionContext=new CScentDiffusionContext("","","","","","","");
		// Get the version
		System.out.println("Exhalia version: " + diffusionContext.GetExhaliaVersion());
		
		diffusionContext.LoadCartridge(false, "d:/Software development/java/exhalia_project/ref/Brunel University - SBi4.cfg");

		//Diffuse the 1st scent
		System.out.println("Diffuse scent 1");		
		diffusionContext.DiffuseCommand(",SCENT_1,,,10,10,");
		
		//Delay until previous fan finishes
		Thread.sleep(10000);

		System.out.println("Diffuse scent 2");	
		diffusionContext.DiffuseCommand(",SCENT_2,,,10,10,");
		
		Thread.sleep(10000);
		
		System.out.println("Diffuse scent 3");		
		diffusionContext.DiffuseCommand(",SCENT_3,,,10,10,");
		
		Thread.sleep(10000);
		
		System.out.println("Diffuse scent 4");		
		diffusionContext.DiffuseCommand(",SCENT_4,,,10,10,");
		
		System.out.println("Finish diffusion.");
	}
}