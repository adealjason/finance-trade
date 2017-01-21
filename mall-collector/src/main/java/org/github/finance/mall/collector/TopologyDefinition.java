package org.github.finance.mall.collector;

/**
 * @author ligaofeng 2017年1月20日 下午1:40:12
 */
public class TopologyDefinition {

    private TopologyDefinition() {
    }

    public static final String topologyName         = "mall-collector-topology";

    public static final String kafkaSpoutName       = "mall-collector-kafka-spout";

    //register
    public static final String assembleUserinfoBolt = "assemble-userinfo-bolt";

}
