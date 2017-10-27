<g:applyLayout name="main">
    <content tag="encabezado">
        <asset:link rel="icon" href="favicon.ico" type="image/x-ico" />
    </content>

    <content tag="encabezado">
        <h1>Creación de Registro</h1>
    </content>

    <content tag="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Level</a></li>
        <li class="active">Here</li>
    </content>

    <content tag="contenido">
        <div class="row">
            <!-- left column -->
            <div class="col-md-6">
                <!-- general form elements -->
                <div class="box box-primary">
                   %{-- <div class="box-header with-border">
                        <h3 class="box-title">Quick Example</h3>
                    </div>--}%
                    <!-- /.box-header -->
                    <!-- form start -->
                    <g:form role="form" action="procesarCreacion" useToken="true">
                        <div class="box-body">
                            <div class="form-group">
                                <label for="matricula">Matrícula</label>
                                <input type="text" class="form-control" name="matricula" id="matricula" required placeholder="Matricula">
                            </div>
                            <div class="form-group">
                                <label for="nombre">Nombre</label>
                                <input type="text" class="form-control" name="nombre" id="nombre" required placeholder="Nombre">
                            </div>
                            <div class="form-group">
                                <label for="email">Email</label>
                                <input type="email" class="form-control" name="email" id="email" placeholder="Email" required>
                            </div>
                            <div class="form-group">
                                <label for="rfid">RFID</label>
                                <input type="number" class="form-control" name="rfid" id="rfid" placeholder="Rfid" required>
                            </div>
                        </div>
                        <!-- /.box-body -->

                        <div class="box-footer">
                            <button type="submit" class="btn btn-primary">Crear</button>
                            <g:link action="lista" class="btn">Cancelar</g:link>
                        </div>
                    </g:form>
                </div>
                <!-- /.box -->
    </content>

</g:applyLayout>