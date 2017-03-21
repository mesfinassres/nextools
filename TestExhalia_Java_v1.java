//--------------------------------------------------------------------------
// Exhalia
//-------------------------------------------------------------------------- 
// Project     : Exhalia
// Sub-Project : SDK
//-------------------------------------------------------------------------- 
// File:     TestExhalia_Java.java
// Creation: 03/04/2002
// Author:   Y. Régeard											
//
// Purpose: Java sample application
//--------------------------------------------------------------------------

package exhalia_project;

// Imports
import exhalia.CScentDiffusionContext;



// TestDiffuser class
public class TestExhalia_Java_v1
{
	// Main class
	public static void main(String[] args)
	{
		// Display the header message
		System.out.println("-------------------------------------");
		System.out.println("-                                  	-");
		System.out.println("-     Test the Java interface      	-");
		System.out.println("-                                  	-");
		System.out.println("- exhalia  version 3.0				-");
		System.out.println("-                                  	-");
		System.out.println("-------------------------------------");
		System.out.println("");

		// Create the diffusion context
		System.out.println("Create the scent diffusion context...");

		CScentDiffusionContext diffusionContext=new CScentDiffusionContext("","SCENT_1","","","10","10","");

		// Get the version
		System.out.println("Get the version...");

		System.out.println(diffusionContext.GetExhaliaVersion());


		// Load a cartridge from file
		System.out.println("Set the cartridge...");

		diffusionContext.LoadCartridge(false,"d:/Software development/java/exhalia_project/ref/Brunel University - SBi4.cfg");

		// Set the cartridge
		System.out.println("Set the cartridge...");

		diffusionContext.SetCartridge(true,"SCENT_1","");

		// Diffuse the scent with the current scent parameters
		System.out.println("Diffuse the scent with the current scent parameters...");

		diffusionContext.Diffuse();

		// Diffuse the scent with the scent parameters
		System.out.println("Diffuse the scent with the scent parameters...");

		diffusionContext.DiffuseScent("","SCENT_2","","5","10","5","");

		// Diffuse the scent with the command parameters 
		System.out.println("Diffuse the scent with the command parameters...");

		diffusionContext.DiffuseCommand(",SCENT_3,,,10,10,");
	}
}

