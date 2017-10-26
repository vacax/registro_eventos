<g:applyLayout name="main">

    <content tag="script">
        <script src="/webjars/AdminLTE/2.4.0/bower_components/chart.js/Chart.js"></script>
        <script>
            $(function () {
                //-------------
                //- PIE CHART -
                //-------------
                // Get context with jQuery - using jQuery's .get() method.
                var pieChartCanvas = $('#pieChart').get(0).getContext('2d');
                var pieChart       = new Chart(pieChartCanvas);
                var PieData        = [
                    {
                        value    : ${entrada},
                        color    : '#f56954',
                        highlight: '#f56954',
                        label    : 'Entrada'
                    },
                    {
                        value    : ${salida},
                        color    : '#00a65a',
                        highlight: '#00a65a',
                        label    : 'Salida'
                    },
                    {
                        value    : ${sinmov},
                        color    : '#f39c12',
                        highlight: '#f39c12',
                        label    : 'Sin Movimiento'
                    }
                ];
                var pieOptions     = {
                    //Boolean - Whether we should show a stroke on each segment
                    segmentShowStroke    : true,
                    //String - The colour of each segment stroke
                    segmentStrokeColor   : '#fff',
                    //Number - The width of each segment stroke
                    segmentStrokeWidth   : 2,
                    //Number - The percentage of the chart that we cut out of the middle
                    percentageInnerCutout: 50, // This is 0 for Pie charts
                    //Number - Amount of animation steps
                    animationSteps       : 100,
                    //String - Animation easing effect
                    animationEasing      : 'easeOutBounce',
                    //Boolean - Whether we animate the rotation of the Doughnut
                    animateRotate        : true,
                    //Boolean - Whether we animate scaling the Doughnut from the centre
                    animateScale         : false,
                    //Boolean - whether to make the chart responsive to window resizing
                    responsive           : true,
                    // Boolean - whether to maintain the starting aspect ratio or not when responsive, if set to false, will take up entire container
                    maintainAspectRatio  : true,
                    //String - A legend template
                    legendTemplate       : ''
                };

                //Create pie or douhnut chart
                // You can switch between pie and douhnut using the method below.
                pieChart.Doughnut(PieData, pieOptions)
            });
        </script>
        }
        //Create pie or douhnut chart
        // You can switch between pie and douhnut using the method below.
        pieChart.Doughnut(PieData, pieOptions)
    </content>

    <content tag="encabezado">
        <asset:link rel="icon" href="favicon.ico" type="image/x-ico" />
    </content>

    <content tag="encabezado">
        <h1>Sistema de Registro de Eventos</h1>
    </content>

    <content tag="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Level</a></li>
        <li class="active">Here</li>
    </content>

    <content tag="contenido">
        <div class="row">
            <div class="col-md-9">
                <div class="box box-danger">
                    <div class="box-header with-border">
                        <h3 class="box-title">Estado Registro</h3>

                        %{--<div class="box-tools pull-right">
                            <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                            </button>
                            <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                        </div>--}%
                    </div>
                    <div class="box-body">
                        <canvas id="pieChart" style="height: 100px;"></canvas>
                    </div>
                    <!-- /.box-body -->
                </div>
                <!-- /.box -->
            </div>
        </div>

    </content>

</g:applyLayout>