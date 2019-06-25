import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/common/login/login.component';
import { RegisterComponent } from './components/common/register/register.component';
import { InboxComponent } from './components/inbox/inbox.component';
import { MessageComponent } from './components/message/message.component';
import { PostFormComponent } from './components/user/post-form/post-form.component';
import { PostListComponent } from './components/user/post-list/post-list.component';
import { PostViewComponent } from './components/user/post-view/post-view.component';
import { AuthGuard } from './guards/auth.guard';


const routes: Routes = [
  { path: '', component: PostListComponent, canActivate: [AuthGuard] },
  { path: 'signup', component: RegisterComponent },
  { path: 'login', component: LoginComponent },
  { path: 'posts/new', component: PostFormComponent, canActivate: [AuthGuard] },
  { path: 'posts/view/:id', component: PostViewComponent, canActivate: [AuthGuard] },
  { path: 'posts/edit/:id', component: PostFormComponent, canActivate: [AuthGuard] },
  { path: 'messages', component: InboxComponent, canActivate: [AuthGuard] },
  { path: 'messages/send/:postId', component: MessageComponent, canActivate: [AuthGuard] },
  { path: '**', redirectTo: '', canActivate: [AuthGuard] }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, { onSameUrlNavigation: 'reload' })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
