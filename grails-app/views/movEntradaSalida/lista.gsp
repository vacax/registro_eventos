<g:applyLayout name="main">

    <content tag="script">
        <script>
            $('#tabla1').DataTable();
        </script>
    </content>
    
    <content tag="encabezado">
        <asset:link rel="icon" href="favicon.ico" type="image/x-ico" />
    </content>

    <content tag="encabezado">
        <h1>Sistema de Gestión de Eventos</h1>
    </content>

    <content tag="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Level</a></li>
        <li class="active">Here</li>
    </content>

    <content tag="contenido">
        <div class="box">
            <!-- /.box-header -->
            <div class="box-body">
                <table id="tabla1" class="table table-bordered table-striped">
                    <thead>
                    <tr>
                        <th>Id</th>
                        <th>Ubicacion</th>
                        <th>Registro</th>
                        <th>Evento</th>
                        <th>Fecha</th>
                    </tr>
                    </thead>
                    <tbody>
                    <g:each in="${listaMov}" var="mov">
                        <tr>
                            <td>${mov.id}</td>
                            <td>${mov.accion}</td>
                            <td>${mov.registro.nombre}</td>
                            <td>${mov.evento.nombre}</td>
                            <td>${mov.dateCreated.format("dd/MM/yyyy HH:mm:ss")}</td>
                        </tr>
                    </g:each>
                    </tbody>
                    %{--<tfoot>
                    <tr>
                        <th>Id</th>
                        <th>Nombre</th>
                        <th>RFID</th>
                        <th></th>
                    </tr>
                    </tfoot>--}%
                </table>
            </div>
            <!-- /.box-body -->
        </div>
        <!-- /.box -->
    </content>

</g:applyLayout>