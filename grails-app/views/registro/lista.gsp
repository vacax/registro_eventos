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
        <h1>Lista de Registro Participante</h1>
    </content>

    <content tag="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Level</a></li>
        <li class="active">Here</li>
    </content>

    <content tag="contenido">
        
        <div class="box">
            <div class="box-header">
                <g:link action="creacion" class="btn btn-primary">Nuevo Registro</g:link>
            </div>
            <!-- /.box-header -->
            <div class="box-body">
                <table id="tabla1" class="table table-bordered table-striped">
                    <thead>
                    <tr>
                        <th>Id</th>
                        <th>Nombre</th>
                        <th>RFID</th>
                        <th>Acciones</th>
                    </tr>
                    </thead>
                    <tbody>
                     <g:each in="${listaRegistro}" var="reg">
                        <tr>
                            <td>${reg.id}</td>
                            <td>${reg.nombre}</td>
                            <td>${reg.rfid}</td>
                            <td>
                                <g:link action="editar" id="${reg.id}">Editar</g:link> |
                                <g:link onclick="return confirm('Desea Eliminar el Registro');" action="borrar" id="${reg.id}">Borrar</g:link>
                            </td>
                        </tr>
                     </g:each>
                    </tbody>
                    <tfoot>
                    <tr>
                        <th>Id</th>
                        <th>Nombre</th>
                        <th>RFID</th>
                        <th></th>
                    </tr>
                    </tfoot>
                </table>
            </div>
            <!-- /.box-body -->
        </div>
        <!-- /.box -->
    </content>

</g:applyLayout>