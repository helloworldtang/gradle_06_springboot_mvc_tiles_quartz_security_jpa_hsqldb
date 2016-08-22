package ihundan.wukonglin.synthesize.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration
@EnableWebMvc
public class ConfigMVC extends WebMvcConfigurerAdapter {

	@Override
	public void configureDefaultServletHandling(
			DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	/**
	 * spring mvc
	 * @return
	 */
	/*@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver view = new InternalResourceViewResolver();
		view.setPrefix("WEB-INF/jsp/");
		view.setSuffix(".jsp");
		return view;
	}*/
	
	@Bean
	public TilesViewResolver viewResolver() {
		TilesViewResolver viewResolver = new TilesViewResolver();
		viewResolver.setViewClass(TilesView.class);
		return viewResolver;
	}

	@Bean
	public TilesConfigurer tilesConfigurer() {
		TilesConfigurer tilesConfigurer = new TilesConfigurer();
		tilesConfigurer.setDefinitions("WEB-INF/tiles.xml");
		tilesConfigurer.setCheckRefresh(true);
		return tilesConfigurer;
	}
	
}
