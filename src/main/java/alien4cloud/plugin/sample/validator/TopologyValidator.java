package alien4cloud.plugin.sample.validator;

import alien4cloud.topology.ITopologyValidatorPlugin;
import alien4cloud.topology.ITopologyValidatorPluginLogger;
import org.alien4cloud.tosca.model.templates.NodeTemplate;
import org.alien4cloud.tosca.model.templates.Topology;
import org.springframework.stereotype.Component;

@Component("simple-topology-validator")
public class TopologyValidator implements ITopologyValidatorPlugin {


    @Override
    public void validate(Topology topology, ITopologyValidatorPluginLogger logger) {

        logger.info("Validated by the sample validator plugin");

        for (NodeTemplate node : topology.getNodeTemplates().values()) {

            if (node.getName().length() < 5) {
                logger.error(String.format("Node %s : minimal node names is 5 characters",node.getName()));
            }

            if (!node.getName().startsWith("A4C")) {
                logger.warn(String.format("Node %s : name should start with A4C",node.getName()));
            }
        }
    }

}
