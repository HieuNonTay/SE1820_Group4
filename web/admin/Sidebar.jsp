<header class="app-header">
    <!-- Sidebar toggle button--><a class="app-sidebar__toggle" href="#" data-toggle="sidebar"
                                    aria-label="Hide Sidebar"></a>
    <!-- Navbar Right Menu-->
    <ul class="app-nav">


        <!-- User Menu-->
        <li><a class="app-nav__item" href="dashboard"><i class='bx bx-log-out bx-rotate-180'></i> </a>

        </li>
    </ul>
</header>
<!-- Sidebar menu-->
<div class="app-sidebar__overlay" data-toggle="sidebar"></div>
<aside class="app-sidebar">
    <div class="app-sidebar__user"><img class="app-sidebar__user-avatar" src="admin/images/user.png" width="50px"
                                        alt="User Image">
        <div>
            <p class="app-sidebar__user-name"><b>${sessionScope.acc.lname}</b></p>
            <p class="app-sidebar__user-designation">Welcome back</p>
        </div>
    </div>
    <hr>
    <ul class="app-menu">
        <li><a class="app-menu__item" href="dashboard"><i class='app-menu__icon bx bx-tachometer'></i><span
                    class="app-menu__label">Dashboard</span></a></li>
        <li><a class="app-menu__item" href="#"><i class='app-menu__icon bx bx-user-voice'></i><span
                    class="app-menu__label">Customer Manager</span></a></li>
        <li><a class="app-menu__item" href="productmanager"><i
                    class='app-menu__icon bx bx-purchase-tag-alt'></i><span class="app-menu__label">Product Manager</span></a>
        </li>
        <li><a class="app-menu__item" href="order"><i class='app-menu__icon bx bx-task'></i><span
                    class="app-menu__label">Oder Manager</span></a></li>
        <li><a class="app-menu__item" href="order"><i class='app-menu__icon bx bx-task'></i><span
                    class="app-menu__label">News Manager</span></a></li>
        <li><a class="app-menu__item" href="order"><i class='app-menu__icon bx bx-task'></i><span
                    class="app-menu__label">Discount Manager</span></a></li>
    </ul>
</aside>