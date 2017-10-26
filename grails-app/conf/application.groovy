

// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'edu.pucmm.re.domains.seguridad.Usuario'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'edu.pucmm.re.domains.seguridad.UsuarioPerfil'
grails.plugin.springsecurity.authority.className = 'edu.pucmm.re.domains.seguridad.Perfil'
grails.plugin.springsecurity.requestMap.className = 'edu.pucmm.re.domains.seguridad.Requestmap'
//grails.plugin.springsecurity.securityConfigType = 'Requestmap'
grails.plugin.springsecurity.controllerAnnotations.staticRules = [
		[pattern: '/',               access: ['permitAll']],
		[pattern: '/error',          access: ['permitAll']],
		[pattern: '/index',          access: ['permitAll']],
		[pattern: '/index.gsp',      access: ['permitAll']],
		[pattern: '/shutdown',       access: ['permitAll']],
		[pattern: '/assets/**',      access: ['permitAll']],
		[pattern: '/webjars/**',     access: ['permitAll']],
		[pattern: '/**/js/**',       access: ['permitAll']],
		[pattern: '/**/css/**',      access: ['permitAll']],
		[pattern: '/**/images/**',   access: ['permitAll']],
		[pattern: '/**/favicon.ico', access: ['permitAll']],
		[pattern: '/movimiento/procesarRegistroEvento', access: ['permitAll']],
		[pattern: '/movimiento/notificacionLector', access: ['permitAll']],
		[pattern: '/login/*', access: ['permitAll']],
		[pattern: '/logout/*', access: ['permitAll']],
		[pattern: '/dbconsole/**', access: ['permitAll']],
		[pattern: '/console/**', access: ['ROLE_ADMIN']],
]

grails.plugin.springsecurity.filterChain.chainMap = [
		[pattern: '/assets/**',      filters: 'none'],
		[pattern: '/**/js/**',       filters: 'none'],
		[pattern: '/**/css/**',      filters: 'none'],
		[pattern: '/**/images/**',   filters: 'none'],
		[pattern: '/**/favicon.ico', filters: 'none'],
		[pattern: '/**',             filters: 'JOINED_FILTERS']
]

