package com.qf.es.config;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
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
	TransportClient transportClient(Settings settings) {
		return new PreBuiltTransportClient(settings);
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
