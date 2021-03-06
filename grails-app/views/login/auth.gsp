<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Registro Eventos</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <link rel="stylesheet" href="/webjars/AdminLTE/2.4.0/bower_components/bootstrap/dist/css/bootstrap.min.css"/>
    <!-- Font Awesome -->
    <link rel="stylesheet" href="/webjars/font-awesome/4.7.0/css/font-awesome.min.css"/>
    <!-- Ionicons -->
    <link rel="stylesheet" href="/webjars/ionicons/2.0.1/css/ionicons.min.css"/>
    <!-- Theme style -->
    <link rel="stylesheet" href="/webjars/AdminLTE/2.4.0/dist/css/AdminLTE.min.css"/>
    <!-- AdminLTE Skins. We have chosen the skin-blue for this starter
        page. However, you can choose any other skin. Make sure you
        apply the skin class to the body tag so the changes take effect. -->
    <link rel="stylesheet" href="/webjars/AdminLTE/2.4.0/dist/css/skins/skin-green.min.css"/>

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
    <!-- Google Font -->
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
    
</head>
<body class="hold-transition login-page">
<div class="login-box">
    <div class="login-logo">
        <a href="../../index2.html"><b>Registro Evento</b></a>
    </div>
    <!-- /.login-logo -->
    <div class="login-box-body">
        <p class="login-box-msg">Inice Sesión</p>

    <g:if test='${flash.message}'>
        <div class="login_message">${flash.message}</div>
    </g:if>

        <form action="${postUrl ?: '/login/authenticate'}" method="POST" id="loginForm">
            <div class="form-group has-feedback">
                <input type="text" class="form-control" placeholder="Usuario" name="${usernameParameter ?: 'username'}" id="username">
                <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <input type="password" class="form-control" placeholder="Password" name="${passwordParameter ?: 'password'}" id="password">
                <span class="glyphicon glyphicon-lock form-control-feedback"></span>
            </div>
            <div class="row">
                %{--<div class="col-xs-8">
                    <div class="checkbox icheck">
                        <label>
                            <input type="checkbox" name="${rememberMeParameter ?: 'remember-me'}" id="remember_me" <g:if test='${hasCookie}'>checked="checked"</g:if>> Remember Me
                        </label>
                    </div>
                </div>--}%
                <!-- /.col -->
                <div class="col-xs-4">
                    <button type="submit" class="btn btn-primary btn-block btn-flat">Sign In</button>
                </div>
                <!-- /.col -->
            </div>
        </form>

        <a href="#">Olvido Su Contraseña</a><br>

    </div>
    <!-- /.login-box-body -->
</div>
<!-- /.login-box -->

<!-- jQuery 3 -->
<script src="/webjars/AdminLTE/2.4.0/bower_components/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="/webjars/AdminLTE/2.4.0/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- AdminLTE App -->
<script src="/webjars/AdminLTE/2.4.0/dist/js/adminlte.min.js"></script>
<script>
    $(function () {
        $('input').iCheck({
            checkboxClass: 'icheckbox_square-blue',
            radioClass: 'iradio_square-blue',
            increaseArea: '20%' // optional
        });
    });
</script>
</body>
</html>