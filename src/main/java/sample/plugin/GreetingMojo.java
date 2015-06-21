package sample.plugin;

import java.util.List;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

@Mojo( name = "sayhi" )
public class GreetingMojo
    extends AbstractMojo
{

    @Parameter( defaultValue = "${reactorProjects}", required = true, readonly = true )
    private List<MavenProject> mavenProjects;

    @Override
    public void execute()
        throws MojoExecutionException, MojoFailureException
    {
        getLog().info( "Hello, world." );
        if ( mavenProjects != null )
        {
            for ( MavenProject mavenProject : mavenProjects )
            {
                getLog().info( " Project: " + mavenProject.getId() );
            }
        }
    }

}
