package sample.plugin;

import java.util.List;

import org.apache.maven.execution.MavenSession;
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

    @Parameter( defaultValue = "${session}", readonly = true, required = true )
    private MavenSession session;

    @Parameter( defaultValue = "${project}", readonly = true, required = true )
    private MavenProject project;

    @Override
    public void execute()
        throws MojoExecutionException, MojoFailureException
    {
        getLog().info( "Hello, world." );


        if ( session.getRequest().isProjectPresent() )
        {
            List<MavenProject> sortedProjects = session.getProjectDependencyGraph().getSortedProjects();
            for ( MavenProject mavenProject : sortedProjects )
            {
                getLog().info( " SortedProject: " + mavenProject.getId() + " BD:" + mavenProject.getBasedir() + " "
                    + mavenProject.getArtifact().getFile() );
            }
        }
        else
        {
            getLog().info( "We have been called directly on a goal base." );
        }

    }

}
