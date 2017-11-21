package com.qf.es.config;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:env/es-config.properties")
public class ESConfig {
	
	@Value("${cluster.nodes}")
	private String clusterNodes;
	
	@Value("${cluster.name}")
	private String clusterName;
	
	@Value("${client.transport.sniff}")
	private String clientTransportSniff;
	
	@Value("${client.transport.ignore_cluster_name}")
	private String clientTransportIgnoreClusterName;
	
	@Value("${client.transport.ping_timeout}")
	private String clientTransportPingTimeout;
	
	@Value("${client.transport.nodes_sampler_interval}")
	private String clientTransportNodesSamplerInterval;
	
	@Bean
	@Autowired
	TransportClient transportClient(Settings settings) throws UnknownHostException {
		TransportClient client = new PreBuiltTransportClient(settings);
		String[] nodes = clusterNodes.split(",");
		for (String node : nodes) {
			if (StringUtils.isNotBlank(node)) {
				String[] hostPort = node.split(":");
				if (hostPort.length == 2 && StringUtils.isNotBlank(hostPort[0]) && StringUtils.isNumeric(hostPort[1])) {
					client.addTransportAddress(new TransportAddress(InetAddress.getByName(hostPort[0]), Integer.valueOf(hostPort[1])));
				}
			}
		}
		return client;
	}
	
	@Bean
	Settings settings() {
		return Settings.builder().
				put("cluster.name", clusterName).
				put("client.transport.sniff", clientTransportSniff).
				put("client.transport.ignore_cluster_name", clientTransportIgnoreClusterName).
				put("client.transport.ping_timeout", clientTransportPingTimeout).
				put("client.transport.nodes_sampler_interval", clientTransportNodesSamplerInterval).build();
	}
	
}
