<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/html">
<head>
    <title>Ваш заказ</title>
    <meta charset="utf-8"/>

    <style type="text/css">
        .header {
            display:flex;
            justify-content:center;
        }
        .content {
            width:100%;
            display:flex;
            justify-content:center;
            flex-wrap: wrap;
        }
        .leftblock {
            flex-grow:1;
        }
        .centerblock {
            flex-grow:8;
        }
        .rigthblock {
            flex-grow:1;
        }
    </style>
</head>
<body>
<div class="header">
    <h1>Ваш заказ</h1>
</div>
<div class="content">

    <div class="leftblock"></div>
    <div class="centerblock">
        <ul>
                <li>Номер заказа: ${order.id}</li>
                <li>Блюдо: ${order.bludo}</li>
                <li>Номер столика: ${order.table_number}</li>
                <li>Имя официанта: ${order.server_name}</li>
        </ul>

    </div>
    <div class="rigthblock"></div>

</div> <!-- content -->
</body>
</html>